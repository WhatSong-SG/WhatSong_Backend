package com.sogong.whatsong.entity.music;

import com.sogong.whatsong.entity.genre.Genre;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cover;

    private String artist;

    private String youtubeLink;

    private String appleLink;

    private String spotifyLink;

    private Integer up;
    
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    public void recommend() {
        this.up++;
    }
}
