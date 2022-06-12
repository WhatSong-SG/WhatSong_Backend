package com.sogong.whatsong.controller;

import com.sogong.whatsong.controller.dto.request.CreateTournamentRequest;
import com.sogong.whatsong.controller.dto.response.CreateTournamentResponse;
import com.sogong.whatsong.service.tournament.TournamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tournament")
public class TournamentController {

    private final TournamentService tournamentService;

    @PostMapping
    public CreateTournamentResponse tournament(@RequestBody CreateTournamentRequest request) {
        return tournamentService.createTournament(request);
    }
}
