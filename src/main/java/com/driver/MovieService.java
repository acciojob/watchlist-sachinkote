package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repo;
	
	public void addMove(Movie movie) {
		// TODO Auto-generated method stub
		
	     repo.addMovie(movie);
	}

	public void addDirector(Director director) {
		// TODO Auto-generated method stub
		repo.addDirector(director);
	}

	public void addMovieDirectorPair(String mname, String dname) {
		// TODO Auto-generated method stub
		repo.addMovieDirectorPair(mname,dname);
		
	}

	public Movie getMovieByName(String name) {
		// TODO Auto-generated method stub
		return repo.getMovieByName(name);
	}

	public Director getDirectorByName(String name) {
		// TODO Auto-generated method stub
		return repo.getDirectorByName(name);
	}

	public List<String> getMoviesByDirectorName(String director) {
		// TODO Auto-generated method stub
		return repo.getMoviesByDirectorName(director) ;
	}

	public List<String> findAllMovies() {
		// TODO Auto-generated method stub
		return repo.findAllMovies();
	}

	public void deleteDirectorByName(String name) {
		// TODO Auto-generated method stub
		 repo.DeleteDirector(name);
	}

	public void deleteAllDirectors() {
		repo.DeleteAllDirector();
		// TODO Auto-generated method stub
		
	}

}
