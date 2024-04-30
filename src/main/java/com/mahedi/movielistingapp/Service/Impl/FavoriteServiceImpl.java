package com.mahedi.movielistingapp.Service.Impl;

import com.mahedi.movielistingapp.Service.FavoriteService;
import com.mahedi.movielistingapp.model.Favorite;
import com.mahedi.movielistingapp.model.Movie;
import com.mahedi.movielistingapp.model.User;
import com.mahedi.movielistingapp.repository.FavoriteRepository;
import com.mahedi.movielistingapp.repository.MovieRepository;
import com.mahedi.movielistingapp.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {

  private final FavoriteRepository favoriteRepository;
  private final MovieRepository movieRepository;
  private final UserRepository userRepository;

  @Override
  public Favorite addMovieToFavorites(Long userId, Long movieId) {
    User user = userRepository.findById(userId).orElse(null);
    Movie movie = movieRepository.findById(movieId).orElse(null);
    if (user != null && movie != null) {
      Favorite favorite = new Favorite();
      favorite.setUser(user);
      favorite.setMovie(movie);
      return favoriteRepository.save(favorite);
    }
    return null;
  }

  @Override
  public void removeMovieFromFavorites(Long userId, Long movieId) {
    Favorite favorite = favoriteRepository.findByUserIdAndMovieId(userId, movieId);
    if (favorite != null) {
      favoriteRepository.delete(favorite);
    }
  }

  @Override
  public List<Movie> searchFavoriteMovies(Long userId, String query) {
    return favoriteRepository.searchFavoriteMoviesByUserId(userId, query);
  }

}
