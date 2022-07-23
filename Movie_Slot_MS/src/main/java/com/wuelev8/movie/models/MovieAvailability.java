package com.wuelev8.movie.models;

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


/*
{
"MovieName": "********",
"Language": "English",
"Address": "********",
"StartDateTime": "2022 - 06 - 15 T07: 00: 00"
}
*/