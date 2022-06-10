package com.sogong.whatsong.service.music;

import com.sogong.whatsong.controller.dto.response.GenreListResponse;
import com.sogong.whatsong.entity.genre.Genre;
import com.sogong.whatsong.entity.genre.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreListResponse getGenreList() {
        List<Genre> genres = genreRepository.findAll();

        return GenreListResponse.builder()
                .genres(genres.stream().map(genre -> GenreListResponse.Genre.builder()
                            .id(genre.getId())
                            .name(genre.getName())
                            .cover(genre.getCover())
                            .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
