package com.wuelev8.movie.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuelev8.movie.models.Movie;
import com.wuelev8.movie.models.MovieAvailability;
import com.wuelev8.movie.models.Response;

public interface Movieregistration {

	Response addMovieSlot(Movie movie);

	Response checkAvailability(MovieAvailability movie);

}