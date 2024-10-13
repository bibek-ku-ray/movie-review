package com.bibek.backend.controller;

import com.bibek.backend.entity.Movie;
import com.bibek.backend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/save")
    public Movie createMovie(@RequestBody Movie movie){
        return movieService.createMovie(movie);
    }

    @GetMapping("/all")
    public List<Movie> getAllMovie(){
        return movieService.getAllMovie();
    }

    @GetMapping("/{id}")
    public Optional<Movie> getMovieById(@PathVariable Integer id){
        return movieService.getMovieById(id);
    }

    @PatchMapping("/{id}")
    public Movie updateMovie(@PathVariable Integer id ,@RequestBody Movie movie){
        return  movieService.updateMovie(id, movie);
    }

    @DeleteMapping("/{id}")
    public Movie deleteMovie(@PathVariable Integer id){
        return  movieService.deleteMovieById(id);
    }
}
