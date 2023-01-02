package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
@Repository
public class MovieRepository {

   HashMap<String,Movie> MovieHashMap= new HashMap<>();
   HashMap<String,Director> DirectorHashMap= new HashMap<>();
   HashMap<String,List<String>> DirectorMoviePair= new HashMap<>();
	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
		
		MovieHashMap.put(movie.getName(), movie);
	}
	public void addDirector(Director director) {
		// TODO Auto-generated method stub
		DirectorHashMap.put(director.getName(), director);
		
	}
	public void addMovieDirectorPair(String mname, String dname) {
		// TODO Auto-generated method stub
		if(MovieHashMap.containsKey(mname) && DirectorHashMap.containsKey(dname))
		{
			List<String> MovieList=new ArrayList<>();
			if(DirectorMoviePair.containsKey(dname))
			{
				MovieList=DirectorMoviePair.get(dname);
				
			}
			MovieList.add(mname);
			DirectorMoviePair.put(dname, MovieList);
					
		
		}
	}
	public Movie getMovieByName(String name) {
		// TODO Auto-generated method stub
		
		return MovieHashMap.get(name);
	}
	public Director getDirectorByName(String name) {
		// TODO Auto-generated method stub
		return DirectorHashMap.get(name);
	}
	public List<String> getMoviesByDirectorName(String director) {
		// TODO Auto-generated method stub
		List<String> list=DirectorMoviePair.get(director);
		return list;
	}
	public List<String> findAllMovies() {
		// TODO Auto-generated method stub
		
		return new ArrayList<>(MovieHashMap.keySet());
	}
 public void DeleteDirector(String director)
 {
	 List<String> Movies=new ArrayList<>();
	 if(DirectorMoviePair.containsKey(director))
	 {
		 Movies=DirectorMoviePair.get(director);
		 for(String movie:Movies)
		 {
			 if(MovieHashMap.containsKey(movie))
			 {
				 MovieHashMap.remove(movie);
			 }
		 }
		 DirectorMoviePair.remove(director);
	 }
	 if(DirectorHashMap.containsKey(director))
		 DirectorHashMap.remove(director);
 }
 public void DeleteAllDirector()
 {
	 HashSet<String> MovieSet=new HashSet<>();
	 DirectorHashMap=new HashMap<>();
	 
	 for(String director : DirectorMoviePair.keySet())
	 {
		 for(String movie: DirectorMoviePair.get(director))
		 {
			 MovieSet.add(movie);
		 }
	 }
	 
	 for(String movie :MovieSet)
	 {
		 if(MovieHashMap.containsKey(movie))
		 {
			 MovieHashMap.remove(movie);
		 }
	 }
 }
	
}
