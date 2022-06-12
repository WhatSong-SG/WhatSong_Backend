package com.sogong.whatsong.entity.tournament;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long> {

    default Tournament getTournament() {
        return Tournament.builder().build();
    }
}
