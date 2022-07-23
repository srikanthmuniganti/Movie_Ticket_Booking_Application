package com.wuelev8.movie.models;

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
	
	@Override
	public String toString() {
		return "MovieAvailability [MovieName=" + MovieName + ", Language=" + Language + ", Address=" + Address
				+ ", StartDateTime=" + StartDateTime + "]";
	}
	
}