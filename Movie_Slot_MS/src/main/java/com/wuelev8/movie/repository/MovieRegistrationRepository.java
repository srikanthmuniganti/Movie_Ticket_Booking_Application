package com.wuelev8.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wuelev8.movie.models.Movie;
import com.wuelev8.movie.models.MovieAvailability;

public interface MovieRegistrationRepository extends JpaRepository<Movie, String> {

	//@Query("select * from movie where MovieName=?.MovieName")
	//MovieAvailability checkAvailability(MovieAvailability movie);
	

}
