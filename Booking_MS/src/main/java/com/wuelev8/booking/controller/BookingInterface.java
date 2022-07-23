package com.wuelev8.booking.controller;

import com.wuelev8.booking.models.AggregateResponse;
import com.wuelev8.booking.models.Movie;
import com.wuelev8.booking.models.Response;
import com.wuelev8.booking.models.UserBookings;

public interface BookingInterface {

	Response bookTickets(Movie movie);

	UserBookings getBookingHistory(String bookedBy, String dateRange);

	AggregateResponse getMovieDetails(String moviename, String dateRange);

}