package innova4b.ejemploSpring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
public class PeliculaFinderFromDB implements PeliculaFinder {
		
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public PeliculaFinderFromDB(DriverManagerDataSource dataSoruce){
		this.jdbcTemplate = new JdbcTemplate(dataSoruce); 
	}

	public List<Pelicula> findAll() {
		List<Pelicula> peliculas = jdbcTemplate.query("select * from movies", new PersonaMapper());			
		return peliculas;
	}
}
