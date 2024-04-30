package com.mahedi.movielistingapp.Service;

import com.mahedi.movielistingapp.model.Movie;
import java.util.List;


public interface MovieService {

  List<Movie> searchMovies(String query);

  Movie getMovieById(Long movieId);
}
