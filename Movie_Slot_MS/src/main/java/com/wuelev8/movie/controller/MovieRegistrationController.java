package com.wuelev8.movie.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wuelev8.movie.models.Movie;
import com.wuelev8.movie.models.MovieAvailability;
import com.wuelev8.movie.models.Response;
import com.wuelev8.movie.models.TotalSeats;
import com.wuelev8.movie.service.MovieRegService;

@RestController
public class MovieRegistrationController implements Movieregistration {

	Logger logger=LoggerFactory.getLogger(getClass());
	
	@Autowired
	MovieRegService service;
	
	@Override
	@ResponseBody
	public Response addMovieSlot(@RequestBody Movie movie) {
		logger.info(" Inside Add Movie Slot -> Request payload : "+ movie);
		return service.addMovieSlot(movie);
	}
	
	@Override
	public Response checkAvailability(@RequestBody MovieAvailability movie)
	{
		logger.info(" Inside check Availability -> Request payload : "+ movie);
		return service.checkAvailability(movie);
	}
	
	@PostMapping("/totalSeats")
	public int totalSeats(@RequestBody TotalSeats seat)
	{
		return service.totalSeats(seat.getMovieName(),seat.getAddress(),seat.getDate());
	}
	
}
