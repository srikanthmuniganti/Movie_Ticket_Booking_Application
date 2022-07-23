package com.wuelev8.booking.controller;

import com.wuelev8.booking.models.Movie;
import com.wuelev8.booking.models.Response;

public interface BookingInterface {

	Response bookTickets(Movie movie);

	Response getBookingHistory(String bookedBy, String dateRange);

}