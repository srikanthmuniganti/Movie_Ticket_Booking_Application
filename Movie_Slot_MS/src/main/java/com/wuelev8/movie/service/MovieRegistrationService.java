package com.wuelev8.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuelev8.movie.models.Movie;
import com.wuelev8.movie.models.MovieAvailability;
import com.wuelev8.movie.models.Response;
import com.wuelev8.movie.repository.MovieRegistrationRepository;

@Service
public class MovieRegistrationService implements MovieRegService {

	@Autowired
	MovieRegistrationRepository repository;
	
	@Override
	public Response addMovieSlot(Movie movie) {
		try {
		repository.save(movie);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new Response("Internal Server error, Please try again !", "500");
		}
		return new Response("Movie Slot created successfully", "201");
	}

	@Override
	public Response checkAvailability(MovieAvailability movie) {
		
		//if(repository.checkAvailability(movie) == null)
		
		return null;
		
	}

	
}
