package com.cognixia.jump.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VideoGame {
	
	private static final long seriaLVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "name", unique = true, nullable = false)
	private String name;
	
	@Column(name = "levels")
	private int levels;
	
	@Column(name = "num_of_players")
	private int numOfPlayers;
	
	@Column(name = "release_year")
	private String release_year;
	
	@Column(name = "genre", columnDefinition = "varchar(30) default 'Undecided'")
	private String genre;
	
	// Constructor
	
	public VideoGame() {
		this(-1,"N/A", 0,0,"2000","N/A");
	}
	
	public VideoGame(int id, String name, int levels, int numOfPlayers, String release_year, String genre) {
		super();
		this.id = id;
		this.name = name;
		this.levels = levels;
		this.numOfPlayers = numOfPlayers;
		this.release_year = release_year;
		this.genre = genre;
	}
	
	// GETTERS & SETTERS 
	
	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevels() {
		return levels;
	}

	public void setLevels(int levels) {
		this.levels = levels;
	}

	public int getNumOfPlayers() {
		return numOfPlayers;
	}

	public void setNumOfPlayers(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}

	public String getRelease_year() {
		return release_year;
	}

	public void setRelease_year(String release_year) {
		this.release_year = release_year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "VideoGame [id=" + id + ", name=" + name + ", levels=" + levels + ", numOfPlayers=" + numOfPlayers
				+ ", release_year=" + release_year + ", genre=" + genre + "]";
	}
	
	// toString method

	
	
	
	
	
	

}
