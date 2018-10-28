package onlinemoviestore.omswebservice.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {
	private String orderid;
	private String orderStatus;
	private String paidStatus;
	private String address;
	private double total;
	private String emailid;
	private String username;
	//@XmlElement(name = "movies")
	private List<Triplet> movies=new ArrayList<>();
	//private HashMap<Long,Details> movies;
	
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", orderStatus=" + orderStatus + ", paidStatus=" + paidStatus
				+ ", address=" + address + ", total=" + total + ", emailid=" + emailid + ", username=" + username
				+ ", movies=" + movies + "]";
	}
	
	public Order(String orderid, String orderStatus, String paidStatus, String address, double total, String emailid,
			String username) {
		super();
		this.orderid = orderid;
		this.orderStatus = orderStatus;
		this.paidStatus = paidStatus;
		this.address = address;
		this.total = total;
		this.emailid = emailid;
		this.username = username;
	}
	
	public Order(String orderid, String orderStatus, String paidStatus, String address, double total, String emailid,
			String username, List<Triplet> movies) {
		super();
		this.orderid = orderid;
		this.orderStatus = orderStatus;
		this.paidStatus = paidStatus;
		this.address = address;
		this.total = total;
		this.emailid = emailid;
		this.username = username;
		this.movies = movies;
	}
	/*
	public void setMovies(HashMap<Long, Details> movies) {
		this.movies = movies;
	}
*/
	
	public Order getObject(){
		Order o=new Order();
		List<Triplet> x=new ArrayList<>();
		x.add(new Triplet(1L,2,200.0));
		x.add(new Triplet(2L,3,150.0));
		o.setAddress("address1");
		o.setEmailid("email1");
		o.setOrderid("orderid");
		o.setOrderStatus("in process");
		o.setPaidStatus("n");
		o.setTotal(250.5);
		o.setUsername("admin");
		//o.movies.add(new Triplet(1L,2,200.0));
		//o.movies.add(new Triplet(2L,3,150.0));
		o.setMovies(x);
		System.out.println("sedr "+o.toString()+" "+o.getMovies());
		System.out.println("a");
		return o;
	}
	
	public Order() {
		super();
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getPaidStatus() {
		return paidStatus;
	}
	public void setPaidStatus(String paidStatus) {
		this.paidStatus = paidStatus;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	//@XmlElement      
	//@XmlElementWrapper(name = "movies")
	public List<Triplet> getMovies() {
		return movies;
	}
	public void setMovies(List<Triplet> movies) {
		this.movies = movies;
	}
	
	
}


/*

class Details{
	private final int quantity;
	private final double price;
	public int getQuantity() {
		return quantity;
	}
	public double getPrice() {
		return price;
	}
	public Details(int quantity, double price) {
		super();
		this.quantity = quantity;
		this.price = price;
	}

}
*/