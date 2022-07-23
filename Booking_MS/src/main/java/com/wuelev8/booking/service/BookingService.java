package com.wuelev8.booking.service;

import com.wuelev8.booking.models.Movie;
import com.wuelev8.booking.models.Response;

public interface BookingService {

	Response bookTickets(Movie movie);

	Response getBookingHistory();

}