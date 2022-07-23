package com.wuelev8.booking.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wuelev8.booking.models.MovieAvailability;
import com.wuelev8.booking.models.Response;

@FeignClient(url = "http://localhost:8080/", name="MovieRegApp")
public interface MovieRegFeignClient {
	
	@PostMapping("/check_availability")
	public Response checkAvailability(@RequestBody MovieAvailability movie);

}
