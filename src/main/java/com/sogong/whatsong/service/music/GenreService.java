package com.sogong.whatsong.service.music;

import com.sogong.whatsong.controller.dto.response.GenreListResponse;
import com.sogong.whatsong.controller.dto.response.MusicListResponse;
import com.sogong.whatsong.entity.genre.Genre;
import com.sogong.whatsong.entity.genre.GenreRepository;
import com.sogong.whatsong.entity.music.Music;
import com.sogong.whatsong.entity.music.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GenreService {

    private final GenreRepository genreRepository;
    private final MusicRepository musicRepository;

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
