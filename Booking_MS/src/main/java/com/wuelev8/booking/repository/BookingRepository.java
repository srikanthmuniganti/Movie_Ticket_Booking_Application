package com.wuelev8.booking.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wuelev8.booking.models.Movie;

public interface BookingRepository extends JpaRepository<Movie, Integer> {

	@Query(value = "select * from Movie where booked_by=?1 and start_date_time>=?2 and start_date_time<=?3", nativeQuery = true)
	List<Movie> findByBoodByAndDateRange(String bookedBy, LocalDateTime date_range,LocalDateTime today);

}
