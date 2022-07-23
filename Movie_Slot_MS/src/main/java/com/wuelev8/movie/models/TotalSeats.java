package com.wuelev8.movie.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TotalSeats {

	private String movieName;
	private String Address;
	@JsonFormat(pattern = "yyyy - MM - dd HH: mm: ss", shape = JsonFormat.Shape.STRING)
	private LocalDateTime date;
	
}
