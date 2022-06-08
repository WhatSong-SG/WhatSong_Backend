package com.sogong.whatsong.controller;

import com.sogong.whatsong.controller.dto.response.DailyMusicResponse;
import com.sogong.whatsong.service.music.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/music")
public class MusicController {

    private final MusicService musicService;

    @GetMapping("/daily")
    public DailyMusicResponse dailyMusic() {
        return musicService.getDailyMusic();
    }
}
