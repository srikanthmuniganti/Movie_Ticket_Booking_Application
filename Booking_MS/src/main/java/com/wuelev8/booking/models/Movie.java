package com.wuelev8.booking.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private String MovieName;
	private String Language;
	private double TicketPrice;
	private int HowManySeats;
	private String MovieTheatreAddress;
	private String BookedBy;
	private Date StartDateTime;
	private Date EndDateTime;
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