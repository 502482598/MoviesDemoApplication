package com.myproj.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproj.movies.exception.ResourceNotFoundException;
import com.myproj.movies.model.Movies;
import com.myproj.movies.repository.MovieRepository;

@RestController
@RequestMapping("api/v1")
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;
	
	@GetMapping("/Movies")
	public List<Movies> getMovieList(){
		return movieRepository.findAll();
	}
	
	@GetMapping("/Movies/{id}")
	public ResponseEntity<Movies> getMovieById(@PathVariable(value="id") Long id) throws ResourceNotFoundException{
		Movies movies = movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie Not Found --" + id));
		return ResponseEntity.ok().body(movies);
	}
}
