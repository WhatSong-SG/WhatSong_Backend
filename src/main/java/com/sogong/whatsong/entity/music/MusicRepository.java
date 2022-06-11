package com.sogong.whatsong.entity.music;

import com.sogong.whatsong.entity.genre.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends CrudRepository<Music, Long> {

    List<Music> findTop10ByOrderByUpDesc();
    List<Music> findByGenreOrderByUpDesc(Genre genre);
}
