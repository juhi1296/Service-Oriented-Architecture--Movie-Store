package onlinemoviestore.omswebservice.database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import onlinemoviestore.omswebservice.model.Movie;

public class Database {
	private final String connectionString="jdbc:mysql://localhost:3306/OnlineMovieStoreDB";
	private final String username="root";
	private final String password="mysql";
	
	public Connection establishConnection(){
		try{ 
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(connectionString,username,password);  
			return con;
		}catch(Exception e)
		{ 
			System.out.println(e.toString());
			return null;
		}
	}
	
}
