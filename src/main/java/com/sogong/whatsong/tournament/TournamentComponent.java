package com.sogong.whatsong.tournament;

import com.sogong.whatsong.entity.music.Music;
import lombok.Getter;
import lombok.Setter;

@Getter
public class TournamentComponent {

    private Boolean isFinish;

    @Setter
    private Music music1;

    @Setter
    private Music music2;

    @Setter
    private Boolean isLeafMatch = false;

    private Music winner;

    private final Integer round;

    @Setter
    private TournamentComponent music1PreComponent;

    @Setter
    private TournamentComponent music2PreComponent;

    public TournamentComponent(Integer round) {
        this.isFinish = false;
        this.round = round;
    }
}
