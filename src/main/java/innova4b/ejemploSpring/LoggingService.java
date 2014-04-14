package innova4b.ejemploSpring;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingService {
	
	@AfterReturning(
		pointcut = "execution(* innova4b.ejemploSpring.PeliculaFinder.findAll(..))",
		returning= "peliculas")
	public void logueoPeliculas(JoinPoint joinPoint, List<Pelicula> peliculas){
		System.out.println("El método "+joinPoint.getSignature()+" se ha ejecutado y ha devuelto las siguientes películas:");
		for (Pelicula pelicula : peliculas)
			System.out.println(pelicula.getNombre());
	}
	
	@Before("execution(* innova4b.ejemploSpring.*.*(..))")
	public void logueoPrevio(JoinPoint joinPoint){
		System.out.println("El método "+joinPoint.getSignature()+" se va a ejecutar");
	}
	
	@After("execution(* innova4b.ejemploSpring.*.*(..))")
	public void logueoPosterior(JoinPoint joinPoint){
		System.out.println("El método "+joinPoint.getSignature()+" se ha ejecutado");
	}
	
	@Around("execution(* innova4b.ejemploSpring.PeliculaLister.*(..))")
	public List<Pelicula> logueoDurante(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("El método "+joinPoint.getSignature()+" se está ejecutado");
		List<Pelicula> peliculas = (List<Pelicula>) joinPoint.proceed();
		return peliculas;		
	}
}
