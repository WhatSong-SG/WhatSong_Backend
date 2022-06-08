package com.sogong.whatsong.entity.dailymusic;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface DailyMusicRepository extends CrudRepository<DailyMusic, LocalDate> {
}
