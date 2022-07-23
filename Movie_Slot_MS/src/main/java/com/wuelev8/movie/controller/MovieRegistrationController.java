package com.wuelev8.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wuelev8.movie.models.Movie;
import com.wuelev8.movie.models.MovieAvailability;
import com.wuelev8.movie.models.Response;
import com.wuelev8.movie.service.MovieRegService;

@RestController
public class MovieRegistrationController implements Movieregistration {

	@Autowired
	MovieRegService service;
	
	@Override
	@PostMapping("/add_movie_slot")
	@ResponseBody
	public Response addMovieSlot(@RequestBody Movie movie) {
		return service.addMovieSlot(movie);
	}
	
	@Override
	@PostMapping("/check_availability")
	public Response checkAvailability(@RequestBody MovieAvailability movie)
	{
		return service.checkAvailability(movie);
	}
	
}
