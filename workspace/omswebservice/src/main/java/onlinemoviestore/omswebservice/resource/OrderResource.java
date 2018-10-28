package onlinemoviestore.omswebservice.resource;

import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import onlinemoviestore.omswebservice.model.Order;
import onlinemoviestore.omswebservice.service.OrderService;

@Path("/orders")
public class OrderResource {
	OrderService os=new OrderService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{emailid}")
	public Order getOrderByCustomer(@PathParam("emailid") String emailid){
		//return os.getOrderByCustomer(emailid);
		Order o=new Order();
		System.out.println("b");
		Order b=o.getObject();
		System.out.println(b.toString());
		return b;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void addOrder(Order order) {
		System.out.println(order.toString());
		os.addOrder(order);
	}
	
	
}
