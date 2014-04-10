package innova4b.ejemploSpring;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        String director = args[0];
        ObjectMapper mapper = new ObjectMapper();
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
        PeliculaLister peliculaLister = context.getBean("peliculaListerFromText",PeliculaLister.class);
		String peliculas = "";
        try {
			peliculas = mapper.writeValueAsString(peliculaLister.findAllByDirector(director));
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("peliculas: "+ peliculas);
        
    }
}
