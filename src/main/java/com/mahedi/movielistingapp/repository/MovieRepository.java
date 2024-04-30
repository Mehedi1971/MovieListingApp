package com.mahedi.movielistingapp.repository;

import com.mahedi.movielistingapp.model.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

  List<Movie> findByTitleContainingOrCastContainingOrCategoryContainingOrderByTitleAsc(
      String title, String cast, String category);


}

