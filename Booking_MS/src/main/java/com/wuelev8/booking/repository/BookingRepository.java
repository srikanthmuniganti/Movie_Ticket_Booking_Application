package com.wuelev8.booking.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wuelev8.booking.models.Movie;

public interface BookingRepository extends JpaRepository<Movie, Integer> {

	List<Movie> findByMovieNameAndStartDateTime(String moviename, LocalDateTime date);

	List<Movie> findByBookedBy(String bookedBy);
}
