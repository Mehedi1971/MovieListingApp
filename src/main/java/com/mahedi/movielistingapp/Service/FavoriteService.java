package com.mahedi.movielistingapp.Service;

import com.mahedi.movielistingapp.model.Favorite;
import com.mahedi.movielistingapp.model.Movie;
import java.util.List;


public interface FavoriteService {


  Favorite addMovieToFavorites(Long userId, Long movieId);

  void removeMovieFromFavorites(Long userId, Long movieId);

  List<Movie> searchFavoriteMovies(Long userId, String query);

}
