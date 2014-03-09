package com.dstsystems.alloy.training.data.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.dstsystems.alloy.training.data.entity.Movie;

public interface MovieRepository extends
		PagingAndSortingRepository<Movie, Long> {

	 List<Movie> findByTitle(String title);
	
	 List<Movie> findByYear(int year);
}
