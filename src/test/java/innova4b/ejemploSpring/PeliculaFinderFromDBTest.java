package innova4b.ejemploSpring;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PeliculaFinderFromDBTest {

PeliculaFinderFromDB peliculaFinderFromDB;
	
	@Before
	public void setUp() throws Exception {		
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
		peliculaFinderFromDB = context.getBean("peliculaFinderFromDB",PeliculaFinderFromDB.class);
	}

	@Test
	public void findAll_recupera_todas_las_peliculas_de_BD() {
		assertEquals(5, peliculaFinderFromDB.findAll().size());
	}
}
