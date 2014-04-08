package innova4b.ejemploSpring;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

public class PeliculaFinderFromDBTest {

	PeliculaFinderFromDB peliculaFinderFromDB;
	
	@Before
	public void setUp() throws Exception {
		DBUtil dbUtil = new DBUtil("jdbc:mysql://localhost/movies", "root", "root");
		Connection connection = dbUtil.getConnection();
		peliculaFinderFromDB = new PeliculaFinderFromDB(connection);
	}

	@Test
	public void findAll_recupera_todas_las_peliculas_de_BD() {
		assertEquals(5, peliculaFinderFromDB.findAll().size());
	}

}
