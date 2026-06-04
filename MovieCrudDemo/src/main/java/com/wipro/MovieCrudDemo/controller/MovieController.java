
package com.wipro.MovieCrudDemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.MovieCrudDemo.entity.Movie;
import com.wipro.MovieCrudDemo.repository.MovieRepository;

@RestController
public class MovieController {

    @Autowired
    MovieRepository repo;

    // Add Movie

    @PostMapping("/movie")
    public ResponseEntity<Movie> saveMovie(
            @RequestBody Movie movie) {

        Movie newMovie = repo.save(movie);

        return ResponseEntity.ok(newMovie);
    }

    // Get All Movies

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies() {

        return ResponseEntity.ok(repo.findAll());
    }

    // Get Movie By ID

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(
            @PathVariable Long id) {

        Optional<Movie> movie = repo.findById(id);

        if (movie.isPresent()) {

            return ResponseEntity.ok(movie.get());

        } else {

            return ResponseEntity.notFound().build();
        }
    }

    // Update Movie

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(
            @PathVariable Long id,
            @RequestBody Movie movie) {

        Optional<Movie> obj = repo.findById(id);

        if (obj.isPresent()) {

            movie.setId(id);

            Movie updatedMovie = repo.save(movie);

            return ResponseEntity.ok(updatedMovie);

        } else {

            return ResponseEntity.notFound().build();
        }
    }

    // Delete Movie

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<String> deleteMovie(
            @PathVariable Long id) {

        Optional<Movie> movie = repo.findById(id);

        if (movie.isPresent()) {

            repo.deleteById(id);

            return ResponseEntity.ok(
                    "Movie Deleted Successfully");

        } else {

            return ResponseEntity.notFound().build();
        }
    }

    // Filter Movies By Rating Greater Than

    @GetMapping("/movies/rating/{rating}")
    public ResponseEntity<List<Movie>> getMoviesByRating(
            @PathVariable double rating) {

        List<Movie> movies =
                repo.findByRatingGreaterThan(rating);

        return ResponseEntity.ok(movies);
    }
}