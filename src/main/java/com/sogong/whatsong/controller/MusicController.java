package com.sogong.whatsong.controller;

import com.sogong.whatsong.controller.dto.response.DailyMusicResponse;
import com.sogong.whatsong.controller.dto.response.MusicInformationResponse;
import com.sogong.whatsong.controller.dto.response.MusicListResponse;
import com.sogong.whatsong.service.music.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/music")
public class MusicController {

    private final MusicService musicService;

    @GetMapping("/daily")
    public DailyMusicResponse dailyMusic() {
        return musicService.getDailyMusic();
    }

    @GetMapping("/top10")
    public MusicListResponse top10() {
        return musicService.getTop10Music();
    }

    @GetMapping("/{music-id}")
    public MusicInformationResponse musicInformation(@PathVariable("music-id") Long musicId) {
        return musicService.getMusicInformation(musicId);
    }

    @GetMapping("/genre/{genre-id}")
    public MusicListResponse musicList(@PathVariable("genre-id") Long genreId) {
        return musicService.getMusicByGenre(genreId);
    }

    @GetMapping("/tournament/rank")
    public MusicListResponse tournamentLank() {
        return musicService.getTournamentRank();
    }

    @PatchMapping("/{music-id}/up")
    public void musicRecommend(@PathVariable("music-id") Long musicId) {
        musicService.recommendMusic(musicId);
    }
}
