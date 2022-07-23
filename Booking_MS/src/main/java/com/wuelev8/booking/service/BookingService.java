package com.wuelev8.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuelev8.booking.client.MovieRegFeignClient;

@Service
public class BookingService {
	
	@Autowired
	MovieRegFeignClient feignClient;
	
	

}
