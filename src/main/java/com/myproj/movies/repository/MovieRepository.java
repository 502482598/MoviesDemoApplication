package com.myproj.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproj.movies.model.Movies;

@Repository
public interface MovieRepository extends JpaRepository<Movies, Long>{

}
