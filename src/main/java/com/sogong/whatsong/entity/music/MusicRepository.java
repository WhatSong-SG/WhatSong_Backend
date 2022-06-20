package com.sogong.whatsong.entity.music;

import com.sogong.whatsong.entity.genre.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends CrudRepository<Music, Long> {

    @Query(value = "select * from music order by rand() limit :limit", nativeQuery = true)
    List<Music> findOrderByRandom(@Param("limit") Integer limit);

    List<Music> findTop10ByOrderByUpDesc();
    List<Music> findByGenreOrderByUpDesc(Genre genre);
    List<Music> findAllByOrderByTournamentWinCountDesc();
}
