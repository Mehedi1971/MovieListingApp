package com.mahedi.movielistingapp.dto;

import com.mahedi.movielistingapp.model.Movie;
import com.mahedi.movielistingapp.model.User;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserFavoritesDto {
  private Long userId;
  private String userEmail;
  private List<MovieDto> favoriteMovies;
}
