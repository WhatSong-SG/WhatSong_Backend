package com.sogong.whatsong.service.music;

import com.sogong.whatsong.controller.dto.response.DailyMusicResponse;
import com.sogong.whatsong.controller.dto.response.MusicInformationResponse;
import com.sogong.whatsong.controller.dto.response.MusicListResponse;
import com.sogong.whatsong.entity.dailymusic.DailyMusic;
import com.sogong.whatsong.entity.dailymusic.DailyMusicRepository;
import com.sogong.whatsong.entity.genre.Genre;
import com.sogong.whatsong.entity.genre.GenreRepository;
import com.sogong.whatsong.entity.music.Music;
import com.sogong.whatsong.entity.music.MusicRepository;
import com.sogong.whatsong.exception.exceptions.GenreNotFoundException;
import com.sogong.whatsong.exception.exceptions.MusicNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MusicService {

    private final DailyMusicRepository dailyMusicRepository;
    private final MusicRepository musicRepository;
    private final GenreRepository genreRepository;

    public DailyMusicResponse getDailyMusic() {
        DailyMusic dailyMusic = dailyMusicRepository.findById(LocalDate.now())
                .orElseThrow(() -> MusicNotFoundException.EXCEPTION);
        Music music = dailyMusic.getMusic();

        return DailyMusicResponse.builder()
                .artist(music.getArtist())
                .trackName(music.getName())
                .cover(music.getCover())
                .link(DailyMusicResponse.Link.builder()
                        .appleMusic(music.getAppleLink())
                        .youtubeMusic(music.getYoutubeLink())
                        .spotify(music.getSpotifyLink())
                        .build())
                .build();
    }

    public MusicListResponse getTop10Music() {
        List<Music> music = musicRepository.findTop10ByOrderByUpDesc();

        return MusicListResponse.builder()
                .music(music.stream().map(m -> MusicListResponse.Music.builder()
                            .id(m.getId())
                            .trackName(m.getName())
                            .cover(m.getCover())
                            .artist(m.getArtist())
                            .date(m.getCreatedAt())
                            .up(m.getUp())
                            .build())
                        .collect(Collectors.toList()))
                .build();
    }

    public MusicListResponse getMusicByGenre(Long genreId) {
        Genre genre = genreRepository.findById(genreId)
                .orElseThrow(() -> GenreNotFoundException.EXCEPTION);

        List<Music> music = musicRepository.findByGenreOrderByUpDesc(genre);

        return MusicListResponse.builder()
                .music(music.stream().map(m -> MusicListResponse.Music.builder()
                        .id(m.getId())
                        .trackName(m.getName())
                        .cover(m.getCover())
                        .artist(m.getArtist())
                        .date(m.getCreatedAt())
                        .up(m.getUp())
                        .build())
                        .collect(Collectors.toList()))
                .build();
    }

    @Transactional
    public void recommendMusic(Long musicId) {
        Music music = musicRepository.findById(musicId)
                .orElseThrow(() -> MusicNotFoundException.EXCEPTION);

        music.recommend();
    }

    public MusicInformationResponse getMusicInformation(Long musicId) {
        Music music = musicRepository.findById(musicId)
                .orElseThrow(() -> MusicNotFoundException.EXCEPTION);

        return MusicInformationResponse.builder()
                .id(music.getId())
                .artist(music.getArtist())
                .trackName(music.getName())
                .cover(music.getCover())
                .link(MusicInformationResponse.Link.builder()
                        .appleMusic(music.getAppleLink())
                        .youtubeMusic(music.getYoutubeLink())
                        .spotify(music.getSpotifyLink())
                        .build())
                .date(music.getCreatedAt())
                .up(music.getUp())
                .build();
    }
}
