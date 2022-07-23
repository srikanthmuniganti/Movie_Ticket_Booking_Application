package com.wuelev8.movie.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response {

	private String StatusTxt;
	private String StatusCode;
}


/*
StatusTxt": "Movie Slot created successfully",
"StatusCode": "201",
*/