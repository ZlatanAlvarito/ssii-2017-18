package es.urjc.etsii;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador Spring para gestión de peticiones REST.
 * 
 * @author J. M. Colmenar
 *
 */
@RestController
public class PeliculasRestController {

	@Autowired
	private PeliculasService peliculasService;

	@RequestMapping(value = "/peliculas", method = RequestMethod.GET)
	public List<Pelicula> getTeams() {
		return peliculasService.getPeliculas();
	}

	@RequestMapping(value = "/peliculas/{index}", method = RequestMethod.GET)
	public Pelicula getPelicula(@PathVariable("index") int index) {
		return peliculasService.getPelicula(index);
	}

	// Para acceder al cuerpo de la petición POST se usa la anotación @RequestBody 
	// en lugar de @RequestParam
	@RequestMapping(value = "/peliculas", method = RequestMethod.POST)
	public ResponseEntity<Boolean> addPelicula(@RequestBody Pelicula peli) {
		peliculasService.addPelicula(peli);
		return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
	}

}
