package com.wuelev8.movie.controller;

import org.springframework.web.bind.annotation.PostMapping;

import com.wuelev8.movie.models.Movie;
import com.wuelev8.movie.models.MovieAvailability;
import com.wuelev8.movie.models.Response;

public interface Movieregistration {

	@PostMapping("/add_movie_slot")
	Response addMovieSlot(Movie movie);

	@PostMapping("/check_availability")
	Response checkAvailability(MovieAvailability movie);

}