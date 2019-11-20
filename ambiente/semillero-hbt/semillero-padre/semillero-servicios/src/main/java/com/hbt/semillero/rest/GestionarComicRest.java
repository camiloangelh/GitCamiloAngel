/**
 * GestionarComicRest.java
 */
package com.hbt.semillero.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarComicLocal;

/**
 * <b>Descripción:<b> Utilizamos GesionarComicBean con el mundo exterior <b>Caso
 * de Uso:<b>
 * 
 * @author camil
 * @version
 */
@Path("/GestionarComic")
public class GestionarComicRest {

	/**
	 * Variable que permite gestionar la clase IGestionarComicLocal
	 */
	@EJB
	private IGestionarComicLocal gestionarComicEJB;

	/**
	 * 
	 * Metodo encargado de realizar la primera prueba rest <b>Caso de Uso</b>
	 * 
	 * 
	 * @return mensaje
	 */
	@GET
	@Path("/saludo") // ruta de acceso
	@Produces // define el tipo de recurso que se va definir
	public String primerRest() {
		return "Hola Mundo, esto es un cambio";
	}

	/**
	 * 
	 * Metodo encargado de traer la informacion de un comic determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/consultarComics
	 * 
	 * @param idComic
	 * @return
	 */
	@GET
	@Path("/consultarComics")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ComicDTO> consultarComic() {
		return gestionarComicEJB.consultarComics();

	}

	/**
	 * 
	 * Metodo encargado de consultar un Comic <b>Caso de Uso</b>
	 * 
	 * @author camil
	 * 
	 * @param idComic
	 * @return
	 */
	@GET
	@Path("/consultarComic")
	@Produces(MediaType.APPLICATION_JSON)
	public ComicDTO consultarComic(@QueryParam("idComic") Long idComic) {
		if (idComic != null) {
			return gestionarComicEJB.consultarComic(idComic.toString());
		}
		return null;
	}

	/**
	 * Crea las personas en sus diferentes roles dentro del sistema.
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/crear
	 * 
	 * @param persona
	 * @return
	 */
	@POST
	@Path("/crear")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearComic(ComicDTO comicDTO) {
		return gestionarComicEJB.crearComic(comicDTO);

	}

	/**
	 * 
	 * Metodo encargado de modificar el nombre de un comic
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/modificar?idComic=1&nombre=nuevonombre
	 * 
	 * @param idComic identificador del comic a buscar
	 * @param nombre  nombre nuevo del comic
	 */
	@POST
	@Path("/modificar")
	@Produces(MediaType.APPLICATION_JSON)
	public void modificarComic(@QueryParam("idComic") Long idComic, @QueryParam("nombre") String nombre) {
		gestionarComicEJB.modificarComic(idComic, nombre, null);
	}

	/**
	 * 
	 * Metodo encargado de eliminar un comic dado el id
	 * 
	 * @param idComic identificador del comic
	 */
	@POST
	@Path("/eliminar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO eliminarComic(@QueryParam("idComic") Long idComic) {
		return gestionarComicEJB.eliminarComic(idComic);

	}

}// Cierre de la clase
