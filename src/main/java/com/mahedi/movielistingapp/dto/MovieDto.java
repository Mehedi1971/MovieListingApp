package com.mahedi.movielistingapp.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

  private Long movieId;
  private String title;
  private String cast;
  private String category;
  private LocalDate releaseDate;
  private double budget;
}
