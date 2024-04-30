package com.mahedi.movielistingapp.Service.Impl;

import com.mahedi.movielistingapp.Service.UserService;
import com.mahedi.movielistingapp.model.Movie;
import com.mahedi.movielistingapp.model.User;
import com.mahedi.movielistingapp.repository.FavoriteRepository;
import com.mahedi.movielistingapp.repository.UserRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImppl implements UserService {

  private final UserRepository userRepository;
  private final FavoriteRepository favoriteRepository;

  @Override
  public User registerUser(String email) {
    User user = new User();
    user.setEmail(email);
    return userRepository.save(user);
  }

  @Override
  public User getUserById(Long userId) {
    Optional<User> optionalUser = userRepository.findById(userId);
    return optionalUser.orElse(null);
  }

  public List<Movie> getUserFavoriteMovies(Long userId) {
    User user = userRepository.findById(userId).orElse(null);
    if (user != null) {
      return favoriteRepository.findFavoriteMoviesByUser(user);
    }
    return Collections.emptyList();
  }
}
