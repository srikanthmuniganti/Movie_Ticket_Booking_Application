package com.wuelev8.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuelev8.booking.client.MovieRegFeignClient;
import com.wuelev8.booking.models.Movie;
import com.wuelev8.booking.models.MovieAvailability;
import com.wuelev8.booking.models.Response;
import com.wuelev8.booking.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	MovieRegFeignClient feignClient;
	
	@Autowired
	BookingRepository repository;

	@Override
	public Response bookTickets(Movie movie) {
		Response response= feignClient.checkAvailability(returnMovieAvail(movie));
		if(response != null) {
			repository.save(movie);
			response.setStatusCode("201");
			response.setStatusTxt("Ticket Booked Successfully");
		}
		else {			
			response=new Response();
			response.setStatusCode("200");
			response.setStatusTxt("Requested Movie is not Available");
			return response;
		}		
		return response;
	}
	
	

	private static MovieAvailability returnMovieAvail(Movie movie) {
		MovieAvailability movieAvailability=new MovieAvailability();
		movieAvailability.setMovieName(movie.getMovieName());
		movieAvailability.setLanguage(movie.getLanguage());
		movieAvailability.setAddress(movie.getMovieTheatreAddress());
		movieAvailability.setStartDateTime(movie.getStartDateTime());
		return movieAvailability;
	}



	@Override
	public Response getBookingHistory() {
		
		return null;
	}
}
