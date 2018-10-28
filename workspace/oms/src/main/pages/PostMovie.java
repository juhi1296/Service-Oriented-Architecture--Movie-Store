package pages;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Movie;
import com.google.gson.Gson;


/**
 * Servlet implementation class PostMovie
 */
@WebServlet("/PostMovie")
public class PostMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostMovie() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 try {

             Movie movie=new Movie();
             String mname = request.getParameter("mname");
             int releaseYear=Integer.parseInt(request.getParameter("year"));
             int availableQty =Integer.parseInt(request.getParameter("aqty"));
             String director=request.getParameter("director");
             String genre = request.getParameter("genre");
             double price=Double.parseDouble(request.getParameter("price"));
             String actor1 = request.getParameter("actor1");
             String actor2 = request.getParameter("actor2");
             List<String> actors=new ArrayList<String>();
             actors.add(actor1);
             actors.add(actor2);
             //PrintWriter out = response.getWriter();
            // out.print(genre);
             
             //output.println(genre);
             
             
		movie.movieName = mname;
		movie.releaseYear = releaseYear;
		movie.availableQty = availableQty;
		movie.director = director;
		movie.genre = genre;
		movie.price = price;
		movie.username ="admin";
		movie.actor=actors;

		URL url = new URL("http://localhost:9999/omswebservice/webapi/movies");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");

               Gson gson = new Gson();
               String json = gson.toJson(movie);
               System.out.println(json);
		//String input = "{\"actor\":[\""+actor1+"\",\"+actor2+"\"],\"availableQty\":"+availableQty+",\"director\":\""+director+"\",\"genre\":\""+genre+"\",\"movieName\":\""+mname+"\",\"price\":"889",\"releaseYear\":"+releaseYear+",\"username\":\"admin\"}";

		DataOutputStream os = new DataOutputStream(conn.getOutputStream());
		os.writeBytes(json);
		os.flush();

		/*if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
			throw new RuntimeException("Failed : HTTP error code : "
				+ conn.getResponseCode());
		}*/

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

		String output;
		System.out.println("Done!");
		/*while ((output = br.readLine()) != null) {
			System.out.println(output);
		}*/

		conn.disconnect();

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	 }
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
