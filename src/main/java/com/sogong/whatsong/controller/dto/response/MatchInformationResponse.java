package com.sogong.whatsong.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MatchInformationResponse {

    private final Integer id;

    private final Music music1;

    private final Music music2;

    private final Integer currentRound;

    private final Integer matchCount;

    private final Integer match;

    @Builder
    @Getter
    public static class Music {

        private final String name;

        private final String cover;

        private final String artist;
    }
}
