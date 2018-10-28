package onlinemoviestore.omswebservice.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import onlinemoviestore.omswebservice.database.Database;
import onlinemoviestore.omswebservice.model.Cart;
import onlinemoviestore.omswebservice.model.Triplet;

public class CartService {
	Database db=new Database();
	
	public Cart getCartItems(String emailid){
		Cart cart=new Cart();
		ArrayList<Triplet> movies=new ArrayList<>();
		
		try(Connection con=db.establishConnection()){
			con.setAutoCommit(false);
			String query = "SELECT * FROM `cart` WHERE `emailid`=?";
			
			try(PreparedStatement stmt=con.prepareStatement(query)){
				stmt.setString(1, emailid);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()){
					movies.add(new Triplet(rs.getLong(2),rs.getInt(3),rs.getDouble(4)));
					
				}
				cart.setMovies(movies);
			}catch(Exception e){
				con.rollback();
				System.out.println("e2 "+e.toString());
			}
			
		}catch(Exception e){
			System.out.println("e2 "+e.toString());
		}
		return cart;
			
	}
	
	public void addItemToCart(String emailid,Triplet movie){
		try(Connection con=db.establishConnection()){
			con.setAutoCommit(false);
			String query="INSERT INTO `cart`(`emailid`, `movie_id`,"
					+ " `quantity`, `price`) VALUES (?,?,?,?)";
			try(PreparedStatement stmt=con.prepareStatement(query)){
				stmt.setString(1, emailid);
				stmt.setLong(2, movie.getMovieid());
				stmt.setInt(3, movie.getQuantity());
				stmt.setDouble(4, movie.getPrice());
				stmt.execute();  
				
			}catch(Exception e){
				con.rollback();
			}
			con.commit();
			con.close();
		}catch(Exception e)
		{ 
			System.out.println(e.toString());
		}
		
	}
	
	
	public void updateItemInCart(String emailid,Triplet movie){
		try(Connection con=db.establishConnection()){
			con.setAutoCommit(false);
			String query="UPDATE `cart` SET `quantity`=? WHERE"
					+ " emailid=? AND movie_id=?";
			try(PreparedStatement stmt=con.prepareStatement(query)){
				
				stmt.setInt(1, movie.getQuantity());
				//stmt.setDouble(2, movie.getPrice());
				stmt.setString(2, emailid);
				stmt.setLong(3, movie.getMovieid());
				System.out.println(stmt.executeUpdate());  
				
			}catch(Exception e){
				con.rollback();
				System.out.println(e.toString());
			}
			con.commit();
			con.close();
		}catch(Exception e)
		{ 
			System.out.println(e.toString());
		}
		
	}
	
	public void DeleteItemInCart(String emailid,long movie_id){
		try(Connection con=db.establishConnection()){
			con.setAutoCommit(false);
			String query="DELETE FROM `cart` WHERE `movie_id`=? and emailid=?";
			try(PreparedStatement stmt=con.prepareStatement(query)){
				
				stmt.setString(2, emailid);
				stmt.setLong(1, movie_id);
				stmt.execute(); 
				
			}catch(Exception e){
				con.rollback();
				System.out.println(e.toString());
			}
			con.commit();
			con.close();
		}catch(Exception e)
		{ 
			System.out.println(e.toString());
		}
		
	}
	
	public void emptyCart(String emailid){
		try(Connection con=db.establishConnection()){
			con.setAutoCommit(false);
			String query="DELETE FROM `cart` WHERE emailid=?";
			try(PreparedStatement stmt=con.prepareStatement(query)){
				
				stmt.setString(1, emailid);
				stmt.execute(); 
				
			}catch(Exception e){
				con.rollback();
				System.out.println(e.toString());
			}
			con.commit();
			con.close();
		}catch(Exception e)
		{ 
			System.out.println(e.toString());
		}
	}
}
