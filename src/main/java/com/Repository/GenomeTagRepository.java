package com.Repository;

import com.entity.GnomeTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenomeTagRepository extends JpaRepository<GnomeTag, Integer> {
}
