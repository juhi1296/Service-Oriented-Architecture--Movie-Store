package onlinemoviestore.omswebservice.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import onlinemoviestore.omswebservice.database.Database;
import onlinemoviestore.omswebservice.model.Movie;
import onlinemoviestore.omswebservice.model.Order;
import onlinemoviestore.omswebservice.model.Triplet;

public class OrderService {
	Database db=new Database();
	
	public void addOrder(Order order) {
		String lastid=new String();
		String orderid=System.currentTimeMillis()+order.getEmailid();
		try(Connection con=db.establishConnection()){
			con.setAutoCommit(false);
			String query="INSERT INTO `orders`(`order_id`, `order_status`,"
					+ " `paid_status`, `address`, `total`, `email_id`, `username`)"
					+ " VALUES (?,?,?,?,?,?,?)";
			try(PreparedStatement stmt=con.prepareStatement(query)){
				stmt.setString(1, orderid);
				stmt.setString(2, order.getOrderStatus());
				stmt.setString(3, order.getPaidStatus());
				stmt.setString(4, order.getAddress());
				stmt.setDouble(5, order.getTotal());
				stmt.setString(6, order.getEmailid());
				stmt.setString(7, order.getUsername());
				
				stmt.execute();  
				/*
				ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next())
                {
                    lastid = rs.getString(1);
                }*/
			}catch(Exception e){
				con.rollback();
			}
			
			query="INSERT INTO `contains`(`movie_id`, `order_id`, `quantity`,"
					+ " `price_at_time`) VALUES (?,?,?,?)";
			try{
				for(Triplet movie : order.getMovies()){
					PreparedStatement stmt=con.prepareStatement(query);
					stmt.setLong(1, movie.getMovieid());
					stmt.setString(2, orderid);
					stmt.setInt(3, movie.getQuantity());
					stmt.setDouble(4, movie.getPrice());
					stmt.execute();
				}
			}catch(Exception e){
				con.rollback();
			}
			
		con.commit();
		con.close();
		}catch(Exception e)
		{ 
			
		}
	}
	
	public Order getOrderByCustomer(String emailid){
		try(Connection con=db.establishConnection()){
			con.setAutoCommit(false);
			String query = "SELECT * FROM `orders` WHERE `email_id`=?";
			try(PreparedStatement stmt=con.prepareStatement(query)){
			    stmt.setString(1, emailid);
			    ResultSet rs = stmt.executeQuery();
			    while (rs.next()){
			    	return new Order(rs.getString(1),rs.getString(2),rs.getString(3),
			    			rs.getString(4),rs.getDouble(5),rs.getString(6),
			    			rs.getString(7));
			    }			
		    }catch(Exception e){
		    	con.rollback();
		    	return null;
			}
		}catch(Exception e){

		}
		return null;
	}
}
