package com.sogong.whatsong.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class GenreListResponse {

    private final List<Genre> genres;

    @Builder
    @Getter
    public static class Genre {

        private final Long id;

        private final String name;

        private final String cover;
    }
}
