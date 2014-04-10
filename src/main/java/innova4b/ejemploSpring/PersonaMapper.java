package innova4b.ejemploSpring;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PersonaMapper implements RowMapper<Pelicula> {

	public Pelicula mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pelicula pelicula = new Pelicula();
		pelicula.setDirector(rs.getString("director"));
		pelicula.setNombre(rs.getString("name"));
		return pelicula;
	}
	
	

}
