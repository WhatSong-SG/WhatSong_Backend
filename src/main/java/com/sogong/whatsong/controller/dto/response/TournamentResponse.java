package com.sogong.whatsong.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TournamentResponse {

    private final Long tournamentId;

    private final Integer matchCount;

    private final Integer round;
}
