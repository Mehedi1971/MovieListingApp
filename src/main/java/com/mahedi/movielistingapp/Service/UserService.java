package com.mahedi.movielistingapp.Service;

import com.mahedi.movielistingapp.model.Movie;
import com.mahedi.movielistingapp.model.User;
import java.util.List;


public interface UserService {

  User registerUser(String email);

  User getUserById(Long userId);

  List<Movie> getUserFavoriteMovies(Long userId);
}
