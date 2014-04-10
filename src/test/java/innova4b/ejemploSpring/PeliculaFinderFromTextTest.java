package innova4b.ejemploSpring;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PeliculaFinderFromTextTest {

PeliculaFinderFromText peliculaFinder;
	
	@Before
	public void setUp() throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
		peliculaFinder = context.getBean("peliculaFinderFromText",PeliculaFinderFromText.class);
	}

	@Test
	public void findAll_recupera_la_lista_de_peliculas() {
		assertEquals(6, peliculaFinder.findAll().size());
	}

}
