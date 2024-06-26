package com.example.movieapi.service;

import com.example.movieapi.model.Movie;
import com.example.movieapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie saveOrUpdate(Movie movie) {
        return movieRepository.save(movie);
    }

    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public List<Movie> findByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }
}
