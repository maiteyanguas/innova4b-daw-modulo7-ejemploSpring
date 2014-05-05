package innova4b.ejemploSpring;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        String director = args[0];
        ObjectMapper mapper = new ObjectMapper();
        ApplicationContext context = new ClassPathXmlApplicationContext("innova4b/ejemploSpring/application-context.xml");
        PeliculaLister peliculaLister = context.getBean("peliculaListerFromText",PeliculaLister.class);
		String peliculas = "";
        try {
			peliculas = mapper.writeValueAsString(peliculaLister.findAllByDirector(director));
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        System.out.println("peliculas: "+ peliculas);
        
    }
}
