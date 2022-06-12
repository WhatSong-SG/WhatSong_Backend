package com.sogong.whatsong.tournament;

import com.sogong.whatsong.entity.music.Music;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TournamentTest {

    @Test
    void 생성_테스트() {
        List<Music> musicList = new ArrayList<>();
        int round = 16;

        for(int i=0; i<round; i++) {
            Music music = Music.builder().id((long) i).build();
            musicList.add(music);
        }

        Tournament tournament = new Tournament(round, musicList);

        assertThat(tournament.getTournamentComponents().size()).isEqualTo(round - 1);
    }
}
