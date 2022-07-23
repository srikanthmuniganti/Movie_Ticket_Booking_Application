package com.wuelev8.booking.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wuelev8.booking.models.AggregateResponse;
import com.wuelev8.booking.models.Movie;
import com.wuelev8.booking.models.Response;
import com.wuelev8.booking.models.UserBookings;
import com.wuelev8.booking.service.BookingService;

@RestController
public class BookingController implements BookingInterface {

	Logger logger=LoggerFactory.getLogger(getClass());
	
	@Autowired
	BookingService service;
	
	@Override
	@PostMapping("/book_tickets")
	public Response bookTickets(@RequestBody Movie movie) {		
		logger.info("Inside Ticket booking Method!!!");
		return service.bookTickets(movie);
	}
	
	@Override
	@GetMapping("/get_booking_history/{bookedBy}/{dateRange}")
	@ResponseBody
	public UserBookings getBookingHistory(@PathVariable String bookedBy,@PathVariable String dateRange) {	
		
		return service.getBookingHistory(bookedBy, dateRange);	
	}
	
	@Override
	@GetMapping("/aggregate_api/{moviename}/{dateRange}")
	@ResponseBody
	public AggregateResponse getMovieDetails(@PathVariable String moviename,@PathVariable String dateRange) {	
		
		return service.getMovieDetails(moviename, dateRange);	
	}
}
