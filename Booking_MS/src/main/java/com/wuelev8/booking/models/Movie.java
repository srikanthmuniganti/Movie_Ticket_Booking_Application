package com.wuelev8.booking.models;

import java.time.LocalDateTime;

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
	private int howManySeats;
	private String movieTheatreAddress;
	private String bookedBy;
	@JsonFormat(pattern = "yyyy - MM - dd HH: mm: ss", shape = JsonFormat.Shape.STRING)
	private LocalDateTime startDateTime;
	@JsonFormat(pattern = "yyyy - MM - dd HH: mm: ss", shape = JsonFormat.Shape.STRING)
	private LocalDateTime endDateTime;
	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieName=" + movieName + ", language=" + language + ", ticketPrice="
				+ ticketPrice + ", howManySeats=" + howManySeats + ", movieTheatreAddress=" + movieTheatreAddress
				+ ", bookedBy=" + bookedBy + ", startDateTime=" + startDateTime + ", endDateTime=" + endDateTime + "]";
	}
	
	
}


/*
{
"MovieName": "********",
"Language": "English",
"TicketPrice": **.**,
"HowManySeats":*
"MovieTheatreAddress": "********",
"BookedBy":"******",
"StartDateTime": "2022 - 06 - 15 T07: 00: 00" ,
"EndDateTime": "2022 - 06 - 15 T07: 01: 59"
}
*/