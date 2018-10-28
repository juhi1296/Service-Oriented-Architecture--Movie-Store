<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add movie</title>
</head>
<body>
<form action="PostMovie" method="POST">
        
        <h1>Add Movie Details!</h1><br><br>
        <h5> Movie Name:            <input type="text" name="mname"></h5><br>
        <h5> Release year:          <input type="text" name="year"></h5><br>
        <h5> Available quantity:    <input type="text" name="aqty"></h5><br>
        <h5> Director:              <input type="text" name="director"></h5><br>
        <h5> Genre:        
            <select name="genre">
                <option id="1" value="Comedy">Comedy</option>
                <option id="2" value="Action">Action</option>
                <option id="3" value="Romance">Romance</option>
                <option id="4" value="Sci-fi">Sci-fi</option>
                <option id="5" value="Thriller">Thriller</option>
            </select></h5>
        <h5> Price:                 <input type="text" name="price"></h5><br>
        <h5> Actors:                <input type="text" name="actor1"><br>
                                    <input type="text" name="actor2"><br></h5>
                                <input type="Submit" value="Submit">
        </form>
</body>
</html>