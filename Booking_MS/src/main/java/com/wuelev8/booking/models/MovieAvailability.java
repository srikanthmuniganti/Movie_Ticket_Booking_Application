package com.wuelev8.booking.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(pattern = "yyyy - MM - dd HH: mm: ss", shape = JsonFormat.Shape.STRING)
	private LocalDateTime StartDateTime;
	
}