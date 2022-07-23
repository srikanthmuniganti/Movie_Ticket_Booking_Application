package com.wuelev8.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wuelev8.booking.models.Movie;
import com.wuelev8.booking.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	BookingService service;
	
	@PostMapping("/book_tickets")
	public void bookTickets(@RequestBody Movie movie) {
		
		
	}
}
