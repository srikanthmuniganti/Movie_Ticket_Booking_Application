package com.wuelev8.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wuelev8.booking.models.Movie;
import com.wuelev8.booking.models.Response;
import com.wuelev8.booking.service.BookingService;

@RestController
public class BookingController implements BookingInterface {

	@Autowired
	BookingService service;
	
	@Override
	@PostMapping("/book_tickets")
	public Response bookTickets(@RequestBody Movie movie) {
		
		return service.bookTickets(movie);
	}
	
	@Override
	@GetMapping("/get_booking_history")
	public Response getBookingHistory() {
		
		return service.getBookingHistory();
		
	}
}
