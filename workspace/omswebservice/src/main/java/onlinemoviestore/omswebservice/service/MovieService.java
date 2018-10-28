package onlinemoviestore.omswebservice.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.PathParam;

import onlinemoviestore.omswebservice.database.Database;
import onlinemoviestore.omswebservice.model.Movie;

public class MovieService {
	Database db=new Database();
	
	public void addMovie(Movie movie) {
		long lastid=-1;
		try(Connection con=db.establishConnection()){
			con.setAutoCommit(false);
			String query="INSERT INTO `movies`(`movie_name`,"
					+ " `release_year`, `available_qty`, `director`, `genre`,"
					+ " `price`, `username`) VALUES (?,?,?,?,?,?,?)";
			try(PreparedStatement stmt=con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS)){
				stmt.setString(1,movie.getMovieName());
				stmt.setInt(2, movie.getReleaseYear());
				stmt.setInt(3, movie.getAvailableQty());
				stmt.setString(4, movie.getDirector());
				stmt.setString(5, movie.getGenre());
				stmt.setDouble(6, movie.getPrice());
				stmt.setString(7, movie.getUsername());
				
				stmt.execute();  
				
				ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next())
                {
                    lastid = rs.getLong(1);
                }
			}catch(Exception e){
				con.rollback();
				System.out.println("1" +e.toString());
			}
			/*
			try(Statement st=con.createStatement()){
				
				ResultSet rs = st.executeQuery("select last_insert_id() as last_id from movies");
				lastid = Long.parseLong(rs.getString("last_id"));
			}catch(Exception e){
				con.rollback();
			}
			*/
			query="INSERT INTO `movies_actors`(`actor`, `movie_id`) VALUES (?,?)";
			try{
				for(String actor : movie.getActor()){
					PreparedStatement stmt=con.prepareStatement(query);
					stmt.setLong(2, lastid);
					stmt.setString(1, actor);
					stmt.execute();
				}
			}catch(Exception e){
				con.rollback();
				System.out.println("2");
				 e.printStackTrace();
			}
			
		con.commit();
		con.close();
		}catch(Exception e)
		{ 
			System.out.println("3" +e.toString());
		}
		
		
		
	}
	
	public List<Movie> getAllMovies() {
		List<Movie> movies=new ArrayList<Movie>();
		try(Connection con=db.establishConnection()){
			con.setAutoCommit(false);
			String query = "SELECT * FROM movies";
		    try(Statement st = con.createStatement()){
			    ResultSet rs = st.executeQuery(query);
			    while (rs.next()){
			    	movies.add(new Movie(rs.getLong(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getDouble(7),rs.getString(8)));
			    }			
		    }catch(Exception e){
				
		    	con.rollback();
		    	return null;
			}
		}catch(Exception e){
			
		}
		return movies;
		
	}
	
	public List<Movie> getMovieByGenre(String genre) {
		List<Movie> movies=new ArrayList<Movie>();
		try(Connection con=db.establishConnection()){
			con.setAutoCommit(false);
			String query = "SELECT * FROM `movies` WHERE `genre`=?";
			try(PreparedStatement stmt=con.prepareStatement(query)){
			    stmt.setString(1, genre);
			    ResultSet rs = stmt.executeQuery();
			    while (rs.next()){
			    	movies.add(new Movie(rs.getLong(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getDouble(7),rs.getString(8)));
			    }			
		    }catch(Exception e){
		    	con.rollback();
		    	return null;
			}
		}catch(Exception e){
		
		}
		return movies;
		
	}
	
	public Movie getMovieById(Long id){
		/*try(Connection con=db.establishConnection()){
			con.setAutoCommit(false);
			String query = "SELECT * FROM `movies` WHERE `movie_id`=?";
			try(PreparedStatement stmt=con.prepareStatement(query)){
			    stmt.setLong(1, id);
			    ResultSet rs = stmt.executeQuery();
			    while (rs.next()){
			    	return new Movie(rs.getLong(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getDouble(7),rs.getString(8));
			    }			
		    }catch(Exception e){
		    	con.rollback();
		    	return null;
			}
		}catch(Exception e){

		}
		return null;*/
		List<String> actors=new ArrayList<String>();
		actors.add("srk");
		actors.add("kajol");
		return new Movie(8L,"ok chal", 2018, 100 , "koi pan", "Action", 355.5,
				"admin",actors);
	}
		
	public void deleteMovie(long movie_id){
		
		try(Connection con=db.establishConnection()){
			con.setAutoCommit(false);
			String query = "UPDATE `movies` SET `available_qty`=?  WHERE `movie_id`=?";
			try(PreparedStatement stmt=con.prepareStatement(query)){
			    stmt.setInt(1, -1);
			    stmt.setLong(2, movie_id);
			    int r = stmt.executeUpdate();
			    			
		    }catch(Exception e){
		    	con.rollback();
		    	
			}
			con.commit();
			con.close();
		}catch(Exception e){

		}
	}
	
	public void updateMovie(long movie_id,Movie movie){
		try(Connection con=db.establishConnection()){
			con.setAutoCommit(false);
			String query="UPDATE `movies` SET `movie_name`=?,"
					+ "`release_year`=?,`available_qty`=?,"
					+ "`director`=?,`genre`=?,`price`=? WHERE `movie_id`=?";
			try(PreparedStatement stmt=con.prepareStatement(query)){
				stmt.setString(1, movie.getMovieName());
				stmt.setInt(2, movie.getReleaseYear());
				stmt.setInt(3, movie.getAvailableQty());
				stmt.setString(4, movie.getDirector());
				stmt.setString(5, movie.getGenre());
				stmt.setDouble(6, movie.getPrice());
				stmt.setLong(7, movie.getMovieid());
				
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
