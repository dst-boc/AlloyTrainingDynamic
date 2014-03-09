package com.dstsystems.alloy.training.api.model;

import java.util.List;

import com.dstsystems.alloy.training.data.entity.Movie;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("movies")
public class MovieList {

	private List<Movie> movies;

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
}
