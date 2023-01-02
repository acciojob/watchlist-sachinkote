package com.driver;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movies")
public class MovieController {

@Autowired
public MovieService service;

@PostMapping("/add-movie")
public ResponseEntity<String> addMovie(@RequestBody Movie movie)
{
	service.addMove(movie);
	return new ResponseEntity<>(" New movie Added Successfully",HttpStatus.CREATED);
}

@PostMapping("/add-director")
public ResponseEntity<String> addDirector(@RequestBody Director director)
{
	service.addDirector(director);
	return new ResponseEntity<>("New Director Added Successfully",HttpStatus.CREATED);
}

@PutMapping("/add-movie-director-pair")
public ResponseEntity<String> addMovieDirectorPair(@RequestParam String mname,@RequestParam String dname)
{
	service.addMovieDirectorPair(mname,dname);
	return new ResponseEntity<>("New Movie-Director Pair Added Succeesfully",HttpStatus.CREATED);
}
@GetMapping("get-movie-by-name/{name}")
public ResponseEntity<Movie> getMovieByName(@PathVariable String name)
{   
	
	Movie movie=service.getMovieByName(name);
	return new ResponseEntity<>(movie,HttpStatus.OK);
}

@GetMapping("get-director-by-name/{name}")
public ResponseEntity<Director> getDirectorByName(@PathVariable String name)
{   
	
	Director director=service.getDirectorByName(name);
	return new ResponseEntity<>(director,HttpStatus.OK);
}

@GetMapping("get-movies-by-director-name/{director}")
public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director)
{   
	
	List<String> list=service.getMoviesByDirectorName(director);
	return new ResponseEntity<>(list,HttpStatus.OK);
}

@GetMapping("get-all-movies")
public ResponseEntity<List<String>> findAllMovies()
{   
	
	List<String> list=service.findAllMovies();
	return new ResponseEntity<>(list,HttpStatus.OK);
}
@DeleteMapping("delete-director-by-name")
public ResponseEntity<String>deleteDirectorByName(@RequestParam String name)
{
	service.deleteDirectorByName(name);
	return new ResponseEntity<>("Deleted Director of this Name",HttpStatus.OK);
	
}

@DeleteMapping("delete-all-directors")
public ResponseEntity<String>deleteAllDirectors()
{
	service.deleteAllDirectors();
	return new ResponseEntity<>("Deleted All Director Successfully",HttpStatus.OK);
	
}

}
