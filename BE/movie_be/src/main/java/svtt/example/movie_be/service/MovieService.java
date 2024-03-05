package svtt.example.movie_be.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import svtt.example.movie_be.entities.Movies;
import svtt.example.movie_be.repository.GenreMovieRepository;
import svtt.example.movie_be.repository.MoviesRepository;
import svtt.example.movie_be.service.imp.MovieServiceIplm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieService implements MovieServiceIplm {
	
	@Autowired
    private final MoviesRepository movieRepository;
	private final GenreMovieRepository genreMovieRepository;
   
    
	
	public MovieService(MoviesRepository movieRepository, GenreMovieRepository genreMovieRepository) {
        this.movieRepository = movieRepository;
        this.genreMovieRepository = genreMovieRepository;
    }

	@Override
	public List<Movies> findByTitleContaining(String title) {
	    return movieRepository.findByTitleContaining( title );
	}
    public List<Map<String, Object>> getAllMovies() {
    	 List<Object[]> resultList = genreMovieRepository.getMovies();
         List<Map<String, Object>> movies = new ArrayList<>();

         for (Object[] row : resultList) {
             Map<String, Object> movieMap = new HashMap<>();
             movieMap.put("movie_id", row[0]);
             movieMap.put("title", row[2]);
             movieMap.put("poster", row[11]);
             movieMap.put("original_language", row[7]);
             movieMap.put("release_date", row[4]);
             movieMap.put("genre_name", row[12]);
             movieMap.put("duration", row[5]);
             movieMap.put("vote_average", row[9]);
             movieMap.put("descriptions", row[3]);
             movies.add(movieMap);
         }

         return movies;
        
    }
    
    public List<Movies> getFirst20Movies() {
        return movieRepository.findFirst20By();
    }

//	public List<Movies> getMovieOverMovieId(Integer movie_id) {
//		return movieRepository.findMovieBymovie_id(movie_id);
//	}

}
