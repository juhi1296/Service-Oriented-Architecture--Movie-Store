package onlinemoviestore.omswebservice.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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
	private long movieid;
	private String movieName;
	private int releaseYear;
	private int availableQty;
	private String director;
	private String genre;
	private double price;
	private String username;
	private List<String> actor;
	
	public long getMovieid() {
		return movieid;
	}
	public void setMovieid(long movieid) {
		this.movieid = movieid;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	public int getAvailableQty() {
		return availableQty;
	}
	public void setAvailableQty(int availableQty) {
		this.availableQty = availableQty;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<String> getActor() {
		return actor;
	}
	public void setActor(List<String> actor) {
		this.actor = actor;
	}
	
	
}
