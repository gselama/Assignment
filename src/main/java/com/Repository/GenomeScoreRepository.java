package com.Repository;

import com.entity.GnomeScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenomeScoreRepository extends JpaRepository<GnomeScore, Integer> {
}
