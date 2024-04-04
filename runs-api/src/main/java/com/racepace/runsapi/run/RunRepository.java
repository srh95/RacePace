package com.racepace.runsapi.run;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RunRepository
        extends JpaRepository<Run, Long> {

    @Query("SELECT r FROM Run r WHERE r.title =?1")
    Optional<Run> findRunByTitle(String title);

    @Query("SELECT r FROM Run r WHERE r.id =?1")
    Optional<Run> findRunById(Long id);


}
