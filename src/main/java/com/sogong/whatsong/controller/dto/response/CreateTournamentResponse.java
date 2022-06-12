package com.sogong.whatsong.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateTournamentResponse {

    private final Long tournamentId;

    private final Integer matchCount;
}
