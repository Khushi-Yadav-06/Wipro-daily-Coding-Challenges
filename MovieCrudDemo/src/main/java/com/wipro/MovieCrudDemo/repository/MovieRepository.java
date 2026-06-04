
package com.wipro.MovieCrudDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.MovieCrudDemo.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // Filter Movies By Rating Greater Than

    List<Movie> findByRatingGreaterThan(double rating);

}

