package innova4b.ejemploSpring;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PeliculaFinderFromDBTest {

PeliculaFinderFromDB peliculaFinderFromDB;
	
	@Before
	public void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("innova4b/ejemploSpring/application-context.xml");
		peliculaFinderFromDB = context.getBean("peliculaFinderFromDB",PeliculaFinderFromDB.class);
	}

	@Test
	public void findAll_recupera_todas_las_peliculas_de_BD() {
		assertEquals(5, peliculaFinderFromDB.findAll().size());
	}
}
