package onlinemoviestore.omswebservice.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "movie")
public class Triplet implements Serializable {
	
	 private long movieid;
	    private int quantity;
	    private double price;

	    
	    
	    public Triplet() {
			super();
		}

		public Triplet(long movieid, int quantity, double price) {
	        this.movieid = movieid;
	        this.quantity = quantity;
	        this.price = price;
	    }
	    
	    public long getMovieid() { return movieid; }
	    public int getQuantity() { return quantity; }
	    public double getPrice() { return price; }

		@Override
		public String toString() {
			return "[movieid=" + movieid + ", quantity=" + quantity + ", price=" + price + "]";
		}
	    
}
