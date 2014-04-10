package innova4b.ejemploSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class ApplicationContextConfig {
	
	@Bean
	public DriverManagerDataSource dataSource(){
		return new DriverManagerDataSource("jdbc:mysql://localhost:3306/movies","root","root");
	}
		    
	@Bean
	public PeliculaFinderFromDB peliculaFinderFromDB(){
		return new PeliculaFinderFromDB(dataSource());
	}
	
	@Bean
	public PeliculaFinderFromText peliculaFinderFromText(){
		PeliculaFinderFromText peliculaFinderFromText = new PeliculaFinderFromText();
		peliculaFinderFromText.setResource("resources/peliculas.txt");
		return peliculaFinderFromText;	
	}
	
	@Bean
	public PeliculaLister peliculaListerFromText(){
		return new PeliculaLister(peliculaFinderFromText());
	} 
	
	@Bean
	public PeliculaLister peliculaListerFromDB(){
		return new PeliculaLister(peliculaFinderFromDB());
	}

}
