package com.mahedi.movielistingapp.Service.Impl;

import com.mahedi.movielistingapp.Service.MovieService;
import com.mahedi.movielistingapp.model.Movie;
import com.mahedi.movielistingapp.repository.MovieRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

  private final MovieRepository movieRepository;

  @Override
  public List<Movie> searchMovies(String query) {
    return movieRepository.findByTitleContainingOrCastContainingOrCategoryContainingOrderByTitleAsc(
        query, query, query);
  }

  @Override
  public Movie getMovieById(Long movieId) {
    Optional<Movie> optionalMovie = movieRepository.findById(movieId);
    return optionalMovie.orElse(null);
  }
}
