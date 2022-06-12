package com.sogong.whatsong.controller;

import com.sogong.whatsong.controller.dto.request.CreateTournamentRequest;
import com.sogong.whatsong.controller.dto.response.MatchInformationResponse;
import com.sogong.whatsong.controller.dto.response.TournamentResponse;
import com.sogong.whatsong.controller.dto.response.TournamentWinnerResponse;
import com.sogong.whatsong.service.tournament.TournamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tournament")
public class TournamentController {

    private final TournamentService tournamentService;

    @PostMapping
    public TournamentResponse tournament(@RequestBody CreateTournamentRequest request) {
        return tournamentService.createTournament(request);
    }

    @GetMapping("/{tournament-id}/match/{match-id}")
    public MatchInformationResponse match(@PathVariable("match-id") Integer matchId, @PathVariable("tournament-id") Long tournamentId) {
        return tournamentService.getMatchInformation(matchId, tournamentId);
    }

    @PostMapping("/{tournament-id}/match/{match-id}/winner/{winner-id}")
    public void winner(@PathVariable("match-id") Integer matchId,
                       @PathVariable("tournament-id") Long tournamentId,
                       @PathVariable("winner-id") Integer winnerId
    ) {
        tournamentService.setWinner(matchId, tournamentId, winnerId);
    }

    @GetMapping("/{tournament-id}/winner")
    public TournamentWinnerResponse winner(@PathVariable("tournament-id") Long tournamentId) {
        return tournamentService.getWinner(tournamentId);
    }
}
