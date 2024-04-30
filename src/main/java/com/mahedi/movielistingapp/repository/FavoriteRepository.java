package com.mahedi.movielistingapp.repository;

import com.mahedi.movielistingapp.model.Favorite;
import com.mahedi.movielistingapp.model.Movie;
import com.mahedi.movielistingapp.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

  @Query("SELECT f.movie FROM Favorite f WHERE f.user = :user")
  List<Movie> findFavoriteMoviesByUser(@Param("user") User user);

  Favorite findByUserIdAndMovieId(Long userId, Long movieId);

  List<Movie> findFavoriteMoviesByUserId(Long userId);

  @Query("SELECT f.movie FROM Favorite f WHERE f.user.id = :userId AND (f.movie.title LIKE %:query% OR f.movie.cast LIKE %:query% OR f.movie.category LIKE %:query%)")
  List<Movie> searchFavoriteMoviesByUserId(@Param("userId") Long userId,
      @Param("query") String query);
}