package com.wuelev8.booking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wuelev8.booking.models.Movie;
import com.wuelev8.booking.models.Response;

public interface BookingInterface {

	Response bookTickets(Movie movie);

	Response getBookingHistory();

}