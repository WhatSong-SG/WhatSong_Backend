package com.sogong.whatsong.controller;

import com.sogong.whatsong.controller.dto.response.GenreListResponse;
import com.sogong.whatsong.service.music.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/genre")
public class GenreController {

    private final GenreService genreService;

    @GetMapping
    public GenreListResponse genreList() {
        return genreService.getGenreList();
    }
}
