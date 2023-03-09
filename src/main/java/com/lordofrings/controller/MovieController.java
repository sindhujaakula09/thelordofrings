package com.lordofrings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {
	private HttpHeaders headers = new HttpHeaders();
	private HttpEntity<String> entity = new HttpEntity<String>(headers);
	private final String resouceUrl = "https://the-one-api.dev/v2/";
	
	private MovieController() {
		headers.set("Authorization", "Bearer OfCZLOecM9CTcdwX7kpU");
	}
    

	@Autowired
	RestTemplate restTemplate;

	// ************GET APIs**************//

	@GetMapping("/movie")
	public ResponseEntity<String> getAllMovies() {
		return restTemplate.exchange(resouceUrl.concat("movie"), HttpMethod.GET, entity, String.class);        
        
	}
	
	@GetMapping("/movie/{id}") 
	public ResponseEntity<String> getMovieById(@PathVariable final String id){
		return restTemplate.exchange(resouceUrl.concat("movie/").concat(id), HttpMethod.GET, entity, String.class); 
	}
	
	@GetMapping("/movie/{id}/quote") 
	public ResponseEntity<String> getMovieQuoteById(@PathVariable final String id){
		return restTemplate.exchange(resouceUrl.concat("movie/").concat(id).concat("/quote"), HttpMethod.GET, entity, String.class); 
	}
	
}
