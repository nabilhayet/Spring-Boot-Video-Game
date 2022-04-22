package com.cognixia.jump.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.VideoGame;

@Repository
public interface VideoGameRepository extends JpaRepository<VideoGame, Integer> {
	
	List<VideoGame> findByGenre(String genre);
	List<VideoGame> findByReleaseYear(String year);

}
