package com.wuelev8.movie.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuelev8.movie.models.Movie;
import com.wuelev8.movie.models.MovieAvailability;
import com.wuelev8.movie.models.Response;
import com.wuelev8.movie.repository.MovieRegistrationRepository;

@Service
public class MovieRegistrationService implements MovieRegService {

	Logger logger=LoggerFactory.getLogger(getClass());
	
	@Autowired
	MovieRegistrationRepository repository;
	
	@Override
	public Response addMovieSlot(Movie movie) {
	try {
		logger.info(" storing object : "+ movie);
		repository.save(movie);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new Response("Movie Slot creation unsuccessfull", "400");
		}
		return new Response("Movie Slot created successfully", "201");
	}

	@Override
	public Response checkAvailability(MovieAvailability movie) {
		List<Movie> list=repository.findByMovieNameAndLanguageAndStartDateTime(movie.getMovieName(),movie.getLanguage(),movie.getStartDateTime());
		logger.info("Inside Check Availability Method!!");
		if(list.size()>0) {
			if(list.get(0).getMovieTheatreAddress().equalsIgnoreCase(movie.getAddress()))
			{
				logger.info("Inside if :"+ list.get(0));
				return	new Response("Available", "200");
			}
		}
		return new  Response("Not Available", "404");		
	}

	@Override
	public int totalSeats(String movieName, String address, LocalDateTime date) {
		List<Movie> list=repository.findByMovieNameAndMovieTheatreAddressAndStartDateTime(movieName,address,date);
		return list.get(0).getTotalSeatCount();
	}

	
}
