package com.sogong.whatsong.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TournamentWinnerResponse {

    private final String name;

    private final String cover;

    private final String artist;
}
