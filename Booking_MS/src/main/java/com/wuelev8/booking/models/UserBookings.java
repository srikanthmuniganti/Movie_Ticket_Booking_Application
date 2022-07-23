package com.wuelev8.booking.models;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserBookings {

	private String name;
	private List<MovieAvailability> movies;
}
