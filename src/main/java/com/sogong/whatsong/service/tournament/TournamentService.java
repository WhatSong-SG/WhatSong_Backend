package com.sogong.whatsong.service.tournament;

import com.sogong.whatsong.controller.dto.request.CreateTournamentRequest;
import com.sogong.whatsong.controller.dto.response.MatchInformationResponse;
import com.sogong.whatsong.controller.dto.response.TournamentResponse;
import com.sogong.whatsong.controller.dto.response.TournamentWinnerResponse;
import com.sogong.whatsong.entity.music.Music;
import com.sogong.whatsong.entity.music.MusicRepository;
import com.sogong.whatsong.entity.tournament.TournamentRepository;
import com.sogong.whatsong.tournament.Tournament;
import com.sogong.whatsong.tournament.TournamentComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;
    private final MusicRepository musicRepository;

    private final Map<Long, Tournament> tournamentMap = new HashMap<>();

    @Transactional
    public TournamentResponse createTournament(CreateTournamentRequest request) {
        Long tournamentId = tournamentRepository.save(tournamentRepository.getTournament()).getId();

        List<Music> music = musicRepository.findOrderByRandom(request.getRound());
        Tournament tournament = new Tournament(request.getRound(), music);

        tournamentMap.put(tournamentId, tournament);

        return TournamentResponse.builder()
                .tournamentId(tournamentId)
                .matchCount(tournament.getMatchCount())
                .round(tournament.getRound())
                .build();
    }

    public MatchInformationResponse getMatchInformation(Integer matchId, Long tournamentId) {
        Tournament tournament = tournamentMap.get(tournamentId);
        if(tournament == null) return null;

        TournamentComponent tc = tournament.getMatches().get(matchId);
        if(tc == null) return null;

        if(tournament.getIsFinish()) return null;

        if(!tc.getIsLeafMatch()) {
            tc.setMusic1(tc.getMusic1PreComponent().getWinner());
            tc.setMusic2(tc.getMusic2PreComponent().getWinner());
        }

        int draw = matchId;
        int round = tournament.getRound() / 2;

        while(draw - round >= 0) {
            draw -= round;
            round /= 2;
        }

        return MatchInformationResponse.builder()
                .id(matchId)
                .music1(MatchInformationResponse.Music.builder()
                        .name(tc.getMusic1().getName())
                        .cover(tc.getMusic1().getCover())
                        .artist(tc.getMusic1().getArtist())
                        .build())
                .music2(MatchInformationResponse.Music.builder()
                        .name(tc.getMusic2().getName())
                        .cover(tc.getMusic2().getCover())
                        .artist(tc.getMusic2().getArtist())
                        .build())
                .currentRound(tc.getRound())
                .matchCount(round)
                .match(draw + 1)
                .isFinish(tc.getIsFinish())
                .build();
    }

    public void setWinner(Integer matchId, Long tournamentId, Integer winnerId) {
        Tournament tournament = tournamentMap.get(tournamentId);
        if (tournament == null) throw new IllegalStateException();

        TournamentComponent tc = tournament.getMatches().get(matchId);
        if (tc == null) throw new IllegalStateException();

        if (tournament.getIsFinish()) throw new IllegalStateException();
        if (tc.getIsFinish()) throw new IllegalStateException();

        switch (winnerId) {
            case 0:
                tc.setWinner(tc.getMusic1());
                break;
            case 1:
                tc.setWinner(tc.getMusic2());
                break;
        }

        tc.setIsFinish(true);

        if (tournament.getMatchCount() - 1 == matchId) {
            Music winner = tc.getWinner();

            tournament.setWinner(winner);
            tournament.setIsFinish(true);

            winner.tournamentWin();
            musicRepository.save(winner);
        }
    }

    public TournamentWinnerResponse getWinner(Long tournamentId) {
        Tournament tournament = tournamentMap.get(tournamentId);

        if (tournament == null) throw new IllegalStateException();
        if (!tournament.getIsFinish()) throw new IllegalStateException();

        return TournamentWinnerResponse.builder()
                .name(tournament.getWinner().getName())
                .cover(tournament.getWinner().getCover())
                .artist(tournament.getWinner().getArtist())
                .build();
    }
}
