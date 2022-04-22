package com.cognixia.jump.controller;

import java.util.List;
// import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.VideoGame;
import com.cognixia.jump.repository.VideoGameRepository;

@RequestMapping("/api")
@RestController
public class VideoGameController {
	
	@Autowired
	VideoGameRepository repo;

	@GetMapping("/videogames")
	public ResponseEntity<Object> getAllVideoGames() {

		List<VideoGame> allVideoGames = repo.findAll();

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(allVideoGames);

	}
	
	@GetMapping("/videogames/{id}")
	public ResponseEntity<Object> getVideoGameById(@PathVariable Integer id) {

		Optional<VideoGame> foundVideoGame = repo.findById(id);

		if (foundVideoGame.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(foundVideoGame.get());
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Video game not found by id " + id);

	}
	
	@GetMapping("/videogames/genre/{genre}")
	public ResponseEntity<Object> getVideoGameById(@PathVariable String genre) {
		
		List<VideoGame> allGames = repo.findByGenre(genre);
		
		if(!allGames.isEmpty()) {
			
			return ResponseEntity.status(HttpStatus.OK).body(allGames);
		}
		
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Video game not found by id " + genre);

		
	}
	
	@GetMapping("/videogames/release_year/{release_year}")
	public ResponseEntity<Object> getVideoGameByReleaseYear(@PathVariable String release_year) {
		
		List<VideoGame> allGames = repo.findByReleaseYear(release_year);
		
		if(!allGames.isEmpty()) {
			
			return ResponseEntity.status(HttpStatus.OK).body(allGames);
		}
		
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Video game not found by year " + release_year);

		
	}
	
	@PostMapping("/addvideogame")
	public ResponseEntity<Object> addVideoGame(@RequestBody VideoGame newGame) {

		VideoGame addedGame = repo.save(newGame);

		return ResponseEntity.status(HttpStatus.CREATED).body(addedGame.toString() + "created");

	}
	
	// PUT 
		@PutMapping("/update")
		public ResponseEntity<Object> updateVideoGame(@RequestBody VideoGame game) {
			
			Optional<VideoGame> found = repo.findById(game.getId());
			
			if(found.isPresent()) {
				repo.save(game);
				return ResponseEntity.status(HttpStatus.OK).body("Video Game updated: " + game.toString());
			}
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Video Game not updated:");
			
		}
		
		// Patch
//		@PatchMapping("/update/patch")
//		public ResponseEntity<Object> patchVideoGame(@RequestBody Map<String, String> patchVideoGame) {
//
//			Optional<VideoGame> updatedVideoGame = repo.findById(Integer.parseInt(patchVideoGame.get("id")));
//			
//			String message = "";
//
//			if (updatedVideoGame.isPresent()) {
//				for (String key : patchVideoGame.keySet()) {
//
//					switch (key) {
//					case "name":	updatedVideoGame.get().setName(patchVideoGame.get("name"));
//						break;
//					case "levels":	updatedVideoGame.get().setLevels(patchVideoGame.get("levels"));
//						break;
//					case "num_of_players":	updatedVideoGame.get().setNumOfPlayers(patchVideoGame.get("num_of_players"));
//						break;
//					case "release_year":	updatedVideoGame.get().setRelease_year(patchVideoGame.get("release_year"));
//						break;
//					case "genre": updatedVideoGame.get().setGenre(patchVideoGame.get("genre"));
//						break;
//					default:
//						message = "Key not found in Student Entity";
//					}
//
//				}
//				repo.save(updatedVideoGame.get());
//				
//				return ResponseEntity.status(HttpStatus.OK).body("Video Game updated with inputs.");
//			}
//			
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);

//		}
		
		// Delete
		
		@DeleteMapping("/delete/videogame/{id}")
		public ResponseEntity<Object> deleteVideoGameById(@PathVariable Integer id) {
			
			//find if the data exists and grab it
			Optional<VideoGame> found = repo.findById(id);
			
			//if exists, delete with repo, return response
			if (found.isPresent()) {
				repo.deleteById(id);
				return ResponseEntity.status(HttpStatus.OK).body("Video Game: " + found.get().toString() + " deleted.");
			}
			
			//not exists, return response that not found
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Video Game: " + id + " not found, not deleted.");
			
		}
	

}
