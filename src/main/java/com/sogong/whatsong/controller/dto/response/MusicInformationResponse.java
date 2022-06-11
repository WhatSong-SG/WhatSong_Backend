package com.sogong.whatsong.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class MusicInformationResponse {

    private final Long id;

    private final String artist;

    private final String trackName;

    private final String cover;

    private final Link link;

    private final LocalDateTime date;

    private final Integer up;

    @Builder
    @Getter
    public static class Link {

        private final String appleMusic;

        private final String youtubeMusic;

        private final String spotify;
    }
}
