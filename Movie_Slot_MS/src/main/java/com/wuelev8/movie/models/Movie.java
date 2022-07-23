package com.wuelev8.movie.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String movieName;
	private String language;
	private double ticketPrice;
	private int totalSeatCount;
	private String addon;
	private String movieTheatreAddress;	
	@JsonFormat(pattern = "yyyy - MM - dd HH: mm: ss", shape = JsonFormat.Shape.STRING)
	private LocalDateTime startDateTime;
	@JsonFormat(pattern = "yyyy - MM - dd HH: mm: ss", shape = JsonFormat.Shape.STRING)
	private LocalDateTime endDateTime;
	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieName=" + movieName + ", language=" + language + ", ticketPrice="
				+ ticketPrice + ", totalSeatCount=" + totalSeatCount + ", addon=" + addon + ", movieTheatreAddress="
				+ movieTheatreAddress + ", startDateTime=" + startDateTime + ", endDateTime=" + endDateTime + "]";
	}
		
}
