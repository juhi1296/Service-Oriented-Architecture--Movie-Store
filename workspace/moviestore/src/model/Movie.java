package model;

import java.util.List;

public class Movie {

	public Movie() {
		super();
	}
	public Movie(Long movieId,String movieName, int releaseYear, int availableQty, String director, String genre, double price,
			String username,List<String> actors) {
		super();
		this.movieid=movieId;
		this.movieName = movieName;
		this.releaseYear = releaseYear;
		this.availableQty = availableQty;
		this.director = director;
		this.genre = genre;
		this.price = price;
		this.username = username;
		this.actor=actors;
	}
	@Override
	public String toString() {
		return "Movie [movieid=" + movieid + ", movieName=" + movieName + ", releaseYear=" + releaseYear
				+ ", availableQty=" + availableQty + ", director=" + director + ", genre=" + genre + ", price=" + price
				+ ", username=" + username + ", actor=" + actor + "]";
	}
	public Movie(long movieid, String movieName, int releaseYear, int availableQty, String director, String genre,
			double price, String username) {
		super();
		this.movieid = movieid;
		this.movieName = movieName;
		this.releaseYear = releaseYear;
		this.availableQty = availableQty;
		this.director = director;
		this.genre = genre;
		this.price = price;
		this.username = username;
	}
	public long movieid;
	public String movieName;
	public int releaseYear;
	public int availableQty;
	public String director;
	public String genre;
	public double price;
	public String username;
	public List<String> actor;
	
	public long getMovieid() {
		return movieid;
        }
}
