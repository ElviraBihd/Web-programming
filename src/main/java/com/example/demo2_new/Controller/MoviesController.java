package com.example.demo2_new.Controller;

import com.example.demo2_new.Model.Movies;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movies")
public class MoviesController {
    private MoviesRepository repository;

    public MoviesController(MoviesRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Movies> getAllMovies(){
        return repository.getAllMovies();

    }

    @PostMapping
    public Movies add(@RequestBody Movies movies){
        repository.addMovie(movies);
        return movies;
    }

    @PutMapping
    public Movies update(@PathVariable Long id, @RequestBody Movies movies){
        movies.setId(id);
        repository.updateMovie(movies);
        return movies;
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id){
        repository.deleteMovie(id);
    }


}
