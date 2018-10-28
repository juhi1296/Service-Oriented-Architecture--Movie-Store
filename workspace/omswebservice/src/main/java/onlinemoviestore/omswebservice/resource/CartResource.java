package onlinemoviestore.omswebservice.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import onlinemoviestore.omswebservice.model.Cart;
import onlinemoviestore.omswebservice.model.Triplet;
import onlinemoviestore.omswebservice.service.CartService;

@Path("/carts")
public class CartResource {
	CartService cs=new CartService();
	
	@GET
	@Path("/{emailid}")
	@Produces(MediaType.APPLICATION_XML)
	public Cart getCartItems(@PathParam("emailid") String emailid){
		return cs.getCartItems(emailid);
	}
	
	@POST
	@Path("/{emailid}")
	@Consumes(MediaType.APPLICATION_XML)
	public void addItemToCart(@PathParam("emailid") String emailid,Triplet movie){
		cs.addItemToCart(emailid, movie);
	}
	
	@PUT
	@Path("/{emailid}")
	@Consumes(MediaType.APPLICATION_XML)
	public void updateItemInCart(@PathParam("emailid") String emailid,Triplet movie){
		cs.updateItemInCart(emailid, movie);
	}
	
	@DELETE
	@Path("/{emailid}/{movie_id}")
	public void DeleteItemInCart(@PathParam("emailid") String emailid,@PathParam("movie_id") long movie_id){
		cs.DeleteItemInCart(emailid, movie_id);
	}
	
	@DELETE
	@Path("/{emailid}")
	public void emptyCart(@PathParam("emailid") String emailid){
		cs.emptyCart(emailid);
	}
}
