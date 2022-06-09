package com.sogong.whatsong.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class MusicListResponse {

    private final List<Music> music;

    @Builder
    @Getter
    public static class Music {

        private final Long id;

        private final String trackName;

        private final String cover;

        private final String artist;

        private final LocalDateTime date;

        private final Integer up;
    }
}
