package com.wuelev8.booking.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuelev8.booking.client.MovieRegFeignClient;
import com.wuelev8.booking.models.AggregateResponse;
import com.wuelev8.booking.models.Movie;
import com.wuelev8.booking.models.MovieAvailability;
import com.wuelev8.booking.models.Response;
import com.wuelev8.booking.models.TotalSeats;
import com.wuelev8.booking.models.UserBookings;
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
		TotalSeats totalSeats=new TotalSeats();
		totalSeats.setMovieName(movie.getMovieName());
		totalSeats.setAddress(movie.getMovieTheatreAddress());
		totalSeats.setDate(movie.getStartDateTime());		
		int totalSeat= feignClient.totalSeats(totalSeats);
		logger.info("total seats are: "+ totalSeat);
		String date=movie.getStartDateTime().format(DateTimeFormatter.ofPattern("yyyy - MM - dd HH: mm: ss"));
		AggregateResponse agr=this.getMovieDetails(movie.getMovieName(), date);
		totalSeat=totalSeat-agr.getTotalTicketSold();
		logger.info("total seats left are: "+ totalSeat);
		if(response.getStatusCode().equals("200") && movie.getHowManySeats()<=totalSeat) {
			logger.info("Saving to Booking repo : "+ movie);
			repository.save(movie);
			response.setStatusCode("201");
			response.setStatusTxt("Ticket Booked Successfully");
		}
		else {			
			response=new Response();
			response.setStatusCode("404");
			response.setStatusTxt("Requested Movie is not Available or No seats Available");
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
	public UserBookings getBookingHistory(String bookedBy, String dateRange) {
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
		List<MovieAvailability> movieAvailabilities=new ArrayList<>();
		List<Movie> movies=repository.findByBookedBy(bookedBy);	
		for(Movie m :movies) {
			boolean b1= m.getStartDateTime().compareTo(today) >0 ? false:true;
			boolean b2= m.getStartDateTime().compareTo(date_range) <1 ? true:false;
			if(b1 && b2)
			{
				movieAvailabilities.add(BookingServiceImpl.returnMovieAvail(m));
			}
		}
		UserBookings userBookings=new UserBookings();
		userBookings.setName(bookedBy);
		userBookings.setMovies(movieAvailabilities);
		return userBookings;
	}



	@Override
	public AggregateResponse getMovieDetails(String moviename, String dateRange) {
		LocalDateTime date=LocalDateTime.parse(dateRange,DateTimeFormatter.ofPattern( "yyyy - MM - dd HH: mm: ss"));
		logger.info(dateRange);
		AggregateResponse response=new AggregateResponse();
		int RevenueEarned=0;
		int TotalTicketSold=0;
		try {
		List<Movie> movies=repository.findByMovieNameAndStartDateTime(moviename,date);		
		for(Movie m: movies) {
			RevenueEarned+=m.getHowManySeats()*m.getTicketPrice();
			TotalTicketSold+=m.getHowManySeats();
		}
		response.setRevenueEarned(RevenueEarned);
		response.setTotalTicketSold(TotalTicketSold);
		}
		catch(Exception e ) {
			response.setRevenueEarned(RevenueEarned);
			response.setTotalTicketSold(TotalTicketSold);
		}
		return response;
	}


}
