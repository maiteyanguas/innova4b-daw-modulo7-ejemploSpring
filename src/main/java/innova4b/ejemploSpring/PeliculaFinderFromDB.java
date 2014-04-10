package innova4b.ejemploSpring;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PeliculaFinderFromDB implements PeliculaFinder {
	
	private Connection connection;
	
	public PeliculaFinderFromDB(Connection connection){
		this.connection = connection; 
	}

	public List<Pelicula> findAll() {
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		Statement statement = null;
		ResultSet resultSet = null;	
		try {			
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from movies");			
			peliculas = writeResultSet(resultSet);
		} catch (SQLException e) {
			System.out.println("Error: "+e.getMessage());
		}
		return peliculas;
		
	}
	
	private List<Pelicula> writeResultSet(ResultSet resultSet) throws SQLException {
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		while (resultSet.next()) {
			Pelicula movie = new Pelicula();
			movie.setDirector(resultSet.getString("director"));
			movie.setNombre(resultSet.getString("name"));
			peliculas.add(movie);
		}
		return peliculas;
	}

}
