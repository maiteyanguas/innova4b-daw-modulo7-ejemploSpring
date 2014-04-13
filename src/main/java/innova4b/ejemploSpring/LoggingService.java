package innova4b.ejemploSpring;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingService {
	
	//tipo after-returning
	public void logueoPeliculas(JoinPoint joinPoint, List<Pelicula> peliculas){
		System.out.println("El método "+joinPoint.getSignature()+" se ha ejecutado y ha devuelto las siguientes películas:");
		for (Pelicula pelicula : peliculas)
			System.out.println(pelicula.getNombre());
	}
	
	//tipo before
	public void logueoPrevio(JoinPoint joinPoint){
		System.out.println("El método "+joinPoint.getSignature()+" se va a ejecutar");
	}
	
    //tipo after
	public void logueoPosterior(JoinPoint joinPoint){
		System.out.println("El método "+joinPoint.getSignature()+" se ha ejecutado");
	}
	
    //tipo around (hay que devolver lo que devuelve el método)
	public List<Pelicula> logueoDurante(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("El método "+joinPoint.getSignature()+" se está ejecutado");
		List<Pelicula> peliculas = (List<Pelicula>) joinPoint.proceed();
		return peliculas;		
	}


}
