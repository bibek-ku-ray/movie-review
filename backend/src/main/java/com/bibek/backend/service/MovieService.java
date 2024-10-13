package com.bibek.backend.service;

import com.bibek.backend.entity.Movie;
import com.bibek.backend.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MovieService {

    @Autowired
    MovieRepo movieRepo;

    public Movie createMovie(Movie movie){
        return movieRepo.save(movie);
    }

    public List<Movie> getAllMovie(){
        return movieRepo.findAll();
    }

    public Optional<Movie> getMovieById(Integer id){
        return movieRepo.findById(id);
    }

    public Movie updateMovie(Integer id, Movie movie){
        Optional<Movie> movieById = movieRepo.findById(id);
        Movie mov = null;

        if(movieById.isPresent()){
            Movie dbMovie = movieById.get();

            if(movie.getTitle() != null)
                dbMovie.setTitle(movie.getTitle());
            if(movie.getDirector() != null)
                dbMovie.setDirector(movie.getDirector());
            if(movie.getYear() != null)
                dbMovie.setYear(movie.getYear());
            if(movie.getGenre() != null)
                dbMovie.setGenre(movie.getGenre());

            mov = movieRepo.save(dbMovie);
        } else {
            System.out.println("Movie not found");
        }
        return mov;
    }

    public Movie deleteMovieById(Integer id){
        Optional<Movie> movie = movieRepo.findById(id);
        if(movie.isPresent()){
            movieRepo.deleteById(id);
        } else {
            System.out.println("Student not found!");
        }
        return movie.get();
    }

}
