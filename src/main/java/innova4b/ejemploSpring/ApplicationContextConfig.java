package innova4b.ejemploSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContextConfig {
	
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
}
