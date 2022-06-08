package com.sogong.whatsong.service.music;

import com.sogong.whatsong.controller.dto.response.DailyMusicResponse;
import com.sogong.whatsong.entity.dailymusic.DailyMusic;
import com.sogong.whatsong.entity.dailymusic.DailyMusicRepository;
import com.sogong.whatsong.entity.music.Music;
import com.sogong.whatsong.entity.music.MusicRepository;
import com.sogong.whatsong.exception.exceptions.MusicNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class MusicService {

    private final DailyMusicRepository dailyMusicRepository;

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
}
