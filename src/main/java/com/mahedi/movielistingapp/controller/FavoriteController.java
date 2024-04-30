package com.mahedi.movielistingapp.controller;

import com.mahedi.movielistingapp.Service.FavoriteService;
import com.mahedi.movielistingapp.model.Favorite;
import com.mahedi.movielistingapp.model.Movie;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/favorites")
@RequiredArgsConstructor
public class FavoriteController {

  private final FavoriteService favoriteService;

  //Add movies to favorites.
  @PostMapping("/{userId}/add")
  public Favorite addMovieToFavorites(@PathVariable Long userId, @RequestParam Long movieId) {
    return favoriteService.addMovieToFavorites(userId, movieId);
  }

  //Remove movies from their favorites.
  @DeleteMapping("/{userId}/remove")
  public void removeMovieFromFavorites(@PathVariable Long userId, @RequestParam Long movieId) {
    favoriteService.removeMovieFromFavorites(userId, movieId);
  }


  //Search movies from users favorites list.
  @GetMapping("/{userId}/search")
  public List<Movie> searchFavoriteMovies(@PathVariable Long userId, @RequestParam String query) {
    return favoriteService.searchFavoriteMovies(userId, query);
  }

}
