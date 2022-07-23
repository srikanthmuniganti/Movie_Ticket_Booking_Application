package com.wuelev8.booking.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

import com.wuelev8.booking.models.MovieAvailability;
import com.wuelev8.booking.models.Response;

@FeignClient(name = "http://localhost:8080/")
public interface MovieRegFeignClient {
	

	public Response checkAvailability(@RequestBody MovieAvailability movie);

}
