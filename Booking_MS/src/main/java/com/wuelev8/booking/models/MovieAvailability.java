package com.wuelev8.booking.models;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MovieAvailability {

	private String MovieName;
	private String Language;
	private String Address;
	private Date StartDateTime;
	
}