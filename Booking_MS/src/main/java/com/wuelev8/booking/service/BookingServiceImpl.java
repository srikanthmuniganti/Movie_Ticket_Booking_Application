package com.wuelev8.booking.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuelev8.booking.client.MovieRegFeignClient;
import com.wuelev8.booking.models.Movie;
import com.wuelev8.booking.models.MovieAvailability;
import com.wuelev8.booking.models.Response;
import com.wuelev8.booking.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {
	Logger logger=LoggerFactory.getLogger(getClass());
	@Autowired
	MovieRegFeignClient feignClient;
	
	@Autowired
	BookingRepository repository;

	@Override
	public Response bookTickets(Movie movie) {
		Response response= feignClient.checkAvailability(returnMovieAvail(movie));
		if(response.getStatusCode().equals("200")) {
			logger.info("Saving to Booking repo : "+ movie);
			repository.save(movie);
			response.setStatusCode("201");
			response.setStatusTxt("Ticket Booked Successfully");
		}
		else {			
			response=new Response();
			response.setStatusCode("404");
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
	public Response getBookingHistory(String bookedBy, String dateRange) {
		LocalDateTime today=LocalDateTime.now();
		LocalDateTime date_range;
		if(dateRange.equalsIgnoreCase("1day"))
		{
			date_range=today.minusDays(1);
		}
		else if(dateRange.equalsIgnoreCase("week"))
		{
			date_range=today.minusWeeks(1);
		}
		else {
			date_range=today.minusMonths(1);
		}
		
		List<Movie> movies=repository.findByBoodByAndDateRange(bookedBy,date_range,today);		
		return null;
	}


}
