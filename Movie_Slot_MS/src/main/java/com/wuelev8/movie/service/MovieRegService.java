package com.wuelev8.movie.service;

import com.wuelev8.movie.models.Movie;
import com.wuelev8.movie.models.MovieAvailability;
import com.wuelev8.movie.models.Response;

public interface MovieRegService {

	Response addMovieSlot(Movie movie);

	Response checkAvailability(MovieAvailability movie);

}