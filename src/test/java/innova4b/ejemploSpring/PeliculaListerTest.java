package innova4b.ejemploSpring;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class PeliculaListerTest {

	PeliculaLister peliculaLister;	
	ApplicationContext context;
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("innova4b/ejemploSpring/application-context.xml");		
	}

	@Test
	public void findAllByDirector_devuelve_las_peliculas_por_director_desde_el_archivo() {		
		peliculaLister = context.getBean("peliculaListerFromText",PeliculaLister.class);
		assertEquals(2,peliculaLister.findAllByDirector("Almodovar").size());
	}
	
	@Test
	public void findAllByName_devuelve_las_peliculas_por_nombre_desde_el_archivo() {
		peliculaLister = context.getBean("peliculaListerFromText",PeliculaLister.class);
		assertEquals(1,peliculaLister.findAllByNombre("Hable con Ella").size());
	}
	
	@Test
	public void findAllByDirector_devuelve_las_peliculas_por_director_desde_BD() {		
		peliculaLister = context.getBean("peliculaListerFromDB",PeliculaLister.class);
		assertEquals(2,peliculaLister.findAllByDirector("Amenabar").size());
	}
	
	@Test
	public void findAllByName_devuelve_las_peliculas_por_nombre_desde_BD() {
		peliculaLister = context.getBean("peliculaListerFromDB",PeliculaLister.class);
		assertEquals(1,peliculaLister.findAllByNombre("Los Otros").size());
	}

}
