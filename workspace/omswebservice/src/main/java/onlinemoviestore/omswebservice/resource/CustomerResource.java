package onlinemoviestore.omswebservice.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import onlinemoviestore.omswebservice.model.Customer;
import onlinemoviestore.omswebservice.model.Movie;
import onlinemoviestore.omswebservice.service.CustomerService;

@Path("/customers")
public class CustomerResource {
	CustomerService cs=new CustomerService();
	
	@GET
	@Path("/{emailid}")
	@Produces(MediaType.APPLICATION_XML)
	public Customer getCustomer(@PathParam("emailid") String emailid){
		return cs.getCustomer(emailid);
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void addCustomer(Customer c){
		cs.addCustomer(c);
	}
	
	@PUT
	@Path("/{emailid}")
	@Consumes(MediaType.APPLICATION_XML)
	public void updateCustomer(@PathParam("emailid") String emailid,Customer c){
		cs.updateCustomer(emailid, c);
	}
	
	
}
