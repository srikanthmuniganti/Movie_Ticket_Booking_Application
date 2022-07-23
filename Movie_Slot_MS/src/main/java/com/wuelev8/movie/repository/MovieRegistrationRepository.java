package com.wuelev8.movie.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wuelev8.movie.models.Movie;

@Repository
public interface MovieRegistrationRepository extends JpaRepository<Movie, String> {

	List<Movie> findByMovieNameAndLanguageAndStartDateTime(String movieName, String language, LocalDateTime startDateTime);

	List<Movie> findByMovieNameAndMovieTheatreAddressAndStartDateTime(String movieName, String address,
			LocalDateTime date);

}
