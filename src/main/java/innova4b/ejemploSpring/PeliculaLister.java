package innova4b.ejemploSpring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeliculaLister {
	
	private PeliculaFinder finder;
	
	public PeliculaLister(PeliculaFinder finder){
		this.finder = finder;
	}
	
	public List<Pelicula> findAllByDirector(String director){
		List<Pelicula> peliculas= new ArrayList<Pelicula>();
		Iterator<Pelicula> it = finder.findAll().iterator();
		while(it.hasNext()){
			Pelicula pelicula = it.next();
			if (pelicula.getDirector().equals(director))
				peliculas.add(pelicula);
		}
		return peliculas;
	}
	
	public List<Pelicula> findAllByNombre(String nombre){
		List<Pelicula> peliculas= new ArrayList<Pelicula>();
		Iterator<Pelicula> it = finder.findAll().iterator();
		while(it.hasNext()){
			Pelicula pelicula = it.next();
			if (pelicula.getNombre().equals(nombre))
				peliculas.add(pelicula);
		}
		return peliculas;
	}

}
