package svtt.example.movie_be.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import svtt.example.movie_be.entities.Movies;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Integer> {

    // You can define custom query methods here if needed
	List<Movies> findByTitleContaining(String title);

//	List<Movies> findMovieByMovieId(Integer movie_id);
	List<Movies> findFirst20By();
}

