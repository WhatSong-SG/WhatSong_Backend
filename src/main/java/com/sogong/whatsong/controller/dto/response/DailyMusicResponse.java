package com.sogong.whatsong.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DailyMusicResponse {

    private final String artist;

    private final String trackName;

    private final String cover;

    private final Link link;

    @Builder
    @Getter
    public static class Link {

        private final String appleMusic;

        private final String youtubeMusic;

        private final String spotify;
    }
}
