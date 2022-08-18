package com.Repository;

import com.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    public List<Movie> fineAllByYearGreaterThanEqualAndLessThanEqual(Integer from, Integer to);

    List<Movie> findByGenreLike(String title);

}
