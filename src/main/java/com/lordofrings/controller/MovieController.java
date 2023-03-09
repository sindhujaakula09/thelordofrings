package com.lordofrings.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {
	private static final String RESOURCE_URL = "https://the-one-api.dev/v2";
	private HttpHeaders headers = new HttpHeaders();
	HttpEntity<String> entity = new HttpEntity<>(headers);
	@Autowired
	RestTemplate restTemplate;

	public MovieController() {

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", "Bearer OfCZLOecM9CTcdwX7kpU");

	}

	@GetMapping(path = "/movie", produces = "application/json")
	public String getMovies() {

		ResponseEntity<String> responseEntity = restTemplate.exchange(RESOURCE_URL.concat("/movie"), HttpMethod.GET,
				entity, String.class);

		return responseEntity.getBody();
	}

	@GetMapping(path = "/movie/{id}", produces = "application/json")
	public String getMoviesById(@PathVariable final String id) {

		ResponseEntity<String> responseEntity = restTemplate.exchange(RESOURCE_URL.concat("/movie/").concat(id),
				HttpMethod.GET, entity, String.class);

		return responseEntity.getBody();
	}

	@GetMapping(path = "/movie/{id}/quote", produces = "application/json")
	public String getMoviesByIdQuote(@PathVariable final String id) {

		ResponseEntity<String> responseEntity = restTemplate.exchange(
				RESOURCE_URL.concat("/movie/").concat(id).concat("/quote"), HttpMethod.GET, entity, String.class);

		return responseEntity.getBody();
	}

}
