package com.sogong.whatsong.tournament;

import com.sogong.whatsong.entity.music.Music;
import lombok.Getter;

import java.util.*;

@Getter
public class Tournament {

    private final Queue<TournamentComponent> tournamentComponents = new LinkedList<>();
    private final List<TournamentComponent> matches = new ArrayList<>();

    private final Integer matchCount;

    private Boolean isFinish;

    private Music winner;

    private final Integer round;

    private final List<Music> musicList;

    public Tournament(Integer round, List<Music> musicList) {
        this.musicList = musicList;
        this.matchCount = round - 1;
        this.isFinish = false;
        this.round = round;

        Queue<TournamentComponent> preMatches = new LinkedList<>();

        while ((round /= 2) != 0) {
            for (int i = 0; i < round; i++) {
                TournamentComponent tc = new TournamentComponent(round*2);

                tournamentComponents.add(tc);
                matches.add(tc);
                preMatches.add(tc);

                if (this.round / 2 == round) {
                    Music music1 = musicList.get(i);
                    Music music2 = musicList.get(this.round - i - 1);

                    tc.setMusic1(music1);
                    tc.setMusic2(music2);

                    tc.setIsLeafMatch(true);
                }

                TournamentComponent testPreTc = preMatches.peek();

                if (testPreTc != null && testPreTc.getRound().equals(round)) {
                    continue;
                }

                TournamentComponent preTc1 = preMatches.poll();
                TournamentComponent preTc2 = preMatches.poll();

                tc.setMusic1PreComponent(preTc1);
                tc.setMusic2PreComponent(preTc2);
            }
        }
    }
}
