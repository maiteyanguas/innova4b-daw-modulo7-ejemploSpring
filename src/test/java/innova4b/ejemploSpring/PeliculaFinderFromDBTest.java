package innova4b.ejemploSpring;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

public class PeliculaFinderFromDBTest {

	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String URL = "jdbc:mysql://localhost/movies";
	PeliculaFinderFromDB peliculaFinderFromDB;
	
	@Before
	public void setUp() throws Exception {
		Connection connection = ConnectionFactory.createConnection(URL, USER, PASSWORD);
		peliculaFinderFromDB = new PeliculaFinderFromDB(connection);
	}

	@Test
	public void findAll_recupera_todas_las_peliculas_de_BD() {
		assertEquals(5, peliculaFinderFromDB.findAll().size());
	}

}
