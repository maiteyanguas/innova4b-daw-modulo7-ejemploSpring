package innova4b.ejemploSpring;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PruebaSingleton {

	@Test
	public void el_bean_es_un_singleton() {
		ApplicationContext context = new ClassPathXmlApplicationContext("innova4b/ejemploSpring/application-context.xml");
		PeliculaFinderFromText peliculaFinderFromText1 = context.getBean("peliculaFinderFromText",PeliculaFinderFromText.class);
		peliculaFinderFromText1.setResource("chuchu");
		PeliculaFinderFromText peliculaFinderFromText2 = context.getBean("peliculaFinderFromText",PeliculaFinderFromText.class);
		peliculaFinderFromText2.setResource("lala");
		assertEquals(peliculaFinderFromText1.getResource(), peliculaFinderFromText2.getResource());
	}

}
