package com.mahedi.movielistingapp.controller;

import com.mahedi.movielistingapp.Service.MovieService;
import com.mahedi.movielistingapp.model.Movie;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

  private final MovieService movieService;

  //Search all the movies in the app with either title, cast or category, etc
  @GetMapping("/search")
  public List<Movie> searchMovies(@RequestParam String query) {
    return movieService.searchMovies(query);
  }

  //See Movie details
  @GetMapping("/{movieId}")
  public Movie getMovieDetails(@PathVariable Long movieId) {
    return movieService.getMovieById(movieId);
  }
}
