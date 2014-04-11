package innova4b.ejemploSpring;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class PeliculaFinderFromText implements PeliculaFinder {
	
	private String resource;
	
	public void setResource(String resource) {
		this.resource = resource;
	}

	public List<Pelicula> findAll(){
		ObjectMapper mapper = new ObjectMapper();
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		try {
			peliculas = mapper.readValue(new File(resource), new TypeReference<List<Pelicula>>() {});
		} catch (IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
		return peliculas;
	}

	public String getResource() {
		return resource;
	}

}
