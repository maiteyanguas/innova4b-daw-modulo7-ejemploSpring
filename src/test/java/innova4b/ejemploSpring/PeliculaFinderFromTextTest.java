package innova4b.ejemploSpring;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PeliculaFinderFromTextTest {

	PeliculaFinderFromText peliculaFinder;
	
	@Before
	public void setUp() throws Exception {
		peliculaFinder = new PeliculaFinderFromText();
		peliculaFinder.setResource("resources/peliculas.txt");
		
	}

	@Test
	public void findAll_recupera_la_lista_de_peliculas() {
		assertEquals(6, peliculaFinder.findAll().size());
	}

}
