package innova4b.ejemploSpring;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.Connection;

public class PeliculaListerTest {

	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String URL = "jdbc:mysql://localhost/movies";
	PeliculaLister peliculaLister;
	PeliculaFinderFromText peliculaFinderFromText;
	PeliculaFinderFromDB peliculaFinderFromDB;
	Connection connection;

	
	@Before
	public void setUp() throws Exception {
		peliculaFinderFromText = new PeliculaFinderFromText();
		peliculaFinderFromText.setResource("resources/peliculas.txt");
		DBUtil dbUtil = new DBUtil(URL, USER, PASSWORD);
		connection = (Connection) dbUtil.getConnection();
		peliculaFinderFromDB = new PeliculaFinderFromDB(connection);
		
	}

	@Test
	public void findAllByDirector_devuelve_las_peliculas_por_director_desde_el_archivo() {		
		peliculaLister = new PeliculaLister(peliculaFinderFromText);
		assertEquals(2,peliculaLister.findAllByDirector("Almodovar").size());
	}
	
	@Test
	public void findAllByName_devuelve_las_peliculas_por_nombre_desde_el_archivo() {
		peliculaLister = new PeliculaLister(peliculaFinderFromText);
		assertEquals(1,peliculaLister.findAllByNombre("Hable con Ella").size());
	}
	
	@Test
	public void findAllByDirector_devuelve_las_peliculas_por_director_desde_BD() {		
		peliculaLister = new PeliculaLister(peliculaFinderFromDB);
		assertEquals(2,peliculaLister.findAllByDirector("Amenabar").size());
	}
	
	@Test
	public void findAllByName_devuelve_las_peliculas_por_nombre_desde_BD() {
		peliculaLister = new PeliculaLister(peliculaFinderFromDB);
		assertEquals(1,peliculaLister.findAllByNombre("Los Otros").size());
	}

}
