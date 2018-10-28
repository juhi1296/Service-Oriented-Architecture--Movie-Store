package onlinemoviestore.omswebservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cart {
	private String emailid;
	private List<Triplet> movies=new ArrayList<>();
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public List<Triplet> getMovies() {
		return movies;
	}
	public void setMovies(List<Triplet> movies) {
		this.movies = movies;
	}
	
	
}
