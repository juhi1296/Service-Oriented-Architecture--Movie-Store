package onlinemoviestore.omswebservice.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import onlinemoviestore.omswebservice.database.Database;
import onlinemoviestore.omswebservice.model.Customer;
import onlinemoviestore.omswebservice.model.Movie;

public class CustomerService {
	Database db=new Database();
	
	public Customer getCustomer(String emailid){
		Customer c = new Customer();
		try(Connection con=db.establishConnection()){
			con.setAutoCommit(false);
			String query = "SELECT * FROM `customer` WHERE `email_id`=?";
			try(PreparedStatement stmt=con.prepareStatement(query)){
			    stmt.setString(1, emailid);
			    ResultSet rs = stmt.executeQuery();
			    while (rs.next()){
			    	
			    	c.setEmailid(rs.getString(1));
			    	c.setFirstName(rs.getString(2));
			    	c.setLastName(rs.getString(3));
			    	c.setHouseNo(rs.getString(5));
			    	c.setSociety(rs.getString(6));
			    	c.setArea(rs.getString(7));
			    	c.setCity(rs.getString(8));
			    	c.setState(rs.getString(9));
			    	c.setPassword(rs.getString(4));
			    }
		    }catch(Exception e){
		    	con.rollback();
		    	System.out.println("e1 "+e.toString());
		    	return null;
			}
			
			query="SELECT `phone_no` FROM `customer_phone_no` WHERE `email_id`=?";
			
			List<String> pno = new ArrayList<>();
			try(PreparedStatement stmt=con.prepareStatement(query)){
				stmt.setString(1, emailid);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()){
					pno.add(rs.getString(1));
				}
				c.setPhoneNo(pno);
			}catch(Exception e){
				con.rollback();
				System.out.println("e2 "+e.toString());
			}
			
		}catch(Exception e){
			System.out.println("e2 "+e.toString());
		}
		return c;
	}
	
	public void addCustomer(Customer c){
		
		try(Connection con=db.establishConnection()){
			con.setAutoCommit(false);
			String query="INSERT INTO `customer`(`email_id`, `first_name`,"
					+ " `last_name`, `password`, `house_no`, `society`,"
					+ " `area`, `city`, `state`) VALUES (?,?,?,?,?,?,?,?,?)";
			try(PreparedStatement stmt=con.prepareStatement(query)){
				stmt.setString(1, c.getEmailid());
				stmt.setString(2, c.getFirstName());
				stmt.setString(3, c.getLastName());
				stmt.setString(4, c.getPassword());
				stmt.setString(5, c.getHouseNo());
				stmt.setString(6, c.getSociety());
				stmt.setString(7, c.getArea());
				stmt.setString(8, c.getCity());
				stmt.setString(9, c.getState());
				
				stmt.execute();  
				
			}catch(Exception e){
				con.rollback();
				System.out.println("e1 "+e.toString());
			}
			
			query="INSERT INTO `customer_phone_no`(`phone_no`, `email_id`) VALUES (?,?)";
			try{
				for(String phone : c.getPhoneNo()){
					PreparedStatement stmt=con.prepareStatement(query);
					stmt.setString(2, c.getEmailid());
					stmt.setString(1, phone);
					stmt.execute();
				}
			}catch(Exception e){
				con.rollback();
				System.out.println("e2 "+e.toString());
			}
			
		con.commit();
		con.close();
		}catch(Exception e)
		{ 
			System.out.println("e3 "+e.toString());
		}
	}
	
	
public void updateCustomer(String emailid,Customer c){
		
		try(Connection con=db.establishConnection()){
			con.setAutoCommit(false);
			String query="UPDATE `customer` SET `first_name`=?,`last_name`=?,"
					+ "`house_no`=?,`society`=?,`area`=?,`city`=?,`state`=?"
					+ " WHERE `email_id`=?";
			try(PreparedStatement stmt=con.prepareStatement(query)){
				stmt.setString(1, c.getFirstName());
				stmt.setString(2, c.getLastName());
				stmt.setString(3, c.getHouseNo());
				stmt.setString(4, c.getSociety());
				stmt.setString(5, c.getArea());
				stmt.setString(6, c.getCity());
				stmt.setString(7, c.getState());
				stmt.setString(8, emailid);
				
				stmt.execute();  
				
			}catch(Exception e){
				con.rollback();
				System.out.println("e1 "+e.toString());
			}
			
		con.commit();
		con.close();
		}catch(Exception e)
		{ 
			System.out.println("e3 "+e.toString());
		}
	}
}
