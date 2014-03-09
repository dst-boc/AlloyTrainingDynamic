package com.dstsystems.alloy.training.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dstsystems.alloy.training.api.model.MovieList;
import com.dstsystems.alloy.training.data.entity.Movie;
import com.dstsystems.alloy.training.data.repository.MovieRepository;

@Controller
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;

	@RequestMapping(value = "/movies")
	public @ResponseBody
	MovieList list(@RequestParam(value = "page", required = false) Integer page) {

		MovieList movieList = new MovieList();
		movieList.setMovies((List<Movie>) movieRepository.findAll());

		return movieList;
	}

	@RequestMapping(value = "/movies", method = RequestMethod.POST)
	public @ResponseBody
	ResponseEntity<Movie> create(@RequestBody Movie movie) {
		movieRepository.save(movie);

		// Prepare acceptable media type
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_JSON);

		// Prepare header
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);

		return new ResponseEntity<Movie>(movie, headers, HttpStatus.CREATED);
	}
}
