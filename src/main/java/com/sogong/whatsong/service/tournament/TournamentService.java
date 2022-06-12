package com.sogong.whatsong.service.tournament;

import com.sogong.whatsong.controller.dto.request.CreateTournamentRequest;
import com.sogong.whatsong.controller.dto.response.CreateTournamentResponse;
import com.sogong.whatsong.entity.music.Music;
import com.sogong.whatsong.entity.music.MusicRepository;
import com.sogong.whatsong.entity.tournament.TournamentRepository;
import com.sogong.whatsong.tournament.Tournament;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;
    private final MusicRepository musicRepository;

    private final Map<Long, Tournament> tournamentMap = new HashMap<>();

    public CreateTournamentResponse createTournament(CreateTournamentRequest request) {
        Long tournamentId = tournamentRepository.save(tournamentRepository.getTournament()).getId();

        List<Music> music = musicRepository.findOrderByRandom(request.getRound());
        Tournament tournament = new Tournament(request.getRound(), music);

        tournamentMap.put(tournamentId, tournament);

        return CreateTournamentResponse.builder()
                .tournamentId(tournamentId)
                .matchCount(tournament.getMatchCount())
                .build();
    }
}
