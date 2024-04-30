package com.mahedi.movielistingapp.controller;

import com.mahedi.movielistingapp.Service.UserService;
import com.mahedi.movielistingapp.dto.MovieDto;
import com.mahedi.movielistingapp.dto.UserFavoritesDto;
import com.mahedi.movielistingapp.model.Movie;
import com.mahedi.movielistingapp.model.User;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  //Register with email address.
  @PostMapping("/register")
  public User registerUser(@RequestParam String email) {
    return userService.registerUser(email);
  }

  //Users personal details and favorites movies list.
  @GetMapping("/{userId}")
  public ResponseEntity<UserFavoritesDto> getUserDetailsWithFavorites(@PathVariable Long userId) {
    User user = userService.getUserById(userId);
    if (user == null) {
      return ResponseEntity.notFound().build();
    }

    List<Movie> favoriteMovies = userService.getUserFavoriteMovies(userId);
    List<MovieDto> favoriteMoviesDTO = favoriteMovies.stream()
        .map(movie -> new MovieDto(
            movie.getId(),
            movie.getTitle(),
            movie.getCast(),
            movie.getCategory(),
            movie.getReleaseDate(),
            movie.getBudget()))
        .collect(Collectors.toList());

    UserFavoritesDto userFavoritesDTO = new UserFavoritesDto(
        user.getId(),
        user.getEmail(),
        favoriteMoviesDTO);

    return ResponseEntity.ok(userFavoritesDTO);
  }


}
