package com.wuelev8.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wuelev8.booking.models.Movie;

public interface BookingRepository extends JpaRepository<Movie, Integer> {

}
