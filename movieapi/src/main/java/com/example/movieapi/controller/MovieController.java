package com.example.movieapi.controller;

import com.example.movieapi.model.Movie;
import com.example.movieapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.saveOrUpdate(movie);
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        Optional<Movie> existingMovie = movieService.findById(id);
        if (existingMovie.isPresent()) {
            movie.setId(id);
            return movieService.saveOrUpdate(movie);
        }
        throw new RuntimeException("Movie not found with id " + id);
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Movie> getMovieById(@PathVariable Long id) {
        return movieService.findById(id);
    }

    @GetMapping("/title/{title}")
    public List<Movie> getMoviesByTitle(@PathVariable String title) {
        return movieService.findByTitle(title);
    }
}
