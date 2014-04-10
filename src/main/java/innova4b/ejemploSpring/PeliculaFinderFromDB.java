package innova4b.ejemploSpring;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class PeliculaFinderFromDB implements PeliculaFinder {
	
	private JdbcTemplate jdbcTemplate;
	
	public PeliculaFinderFromDB(DriverManagerDataSource dataSoruce){
		this.jdbcTemplate = new JdbcTemplate(dataSoruce); 
	}

	public List<Pelicula> findAll() {
		List<Pelicula> peliculas = jdbcTemplate.query("select * from movies", new PersonaMapper());			
		return peliculas;
	}
}
