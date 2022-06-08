package com.sogong.whatsong.entity.dailymusic;

import com.sogong.whatsong.entity.music.Music;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class DailyMusic {

    @Id
    LocalDate date;

    @ManyToOne
    @JoinColumn(name = "music_id")
    private Music music;
}
