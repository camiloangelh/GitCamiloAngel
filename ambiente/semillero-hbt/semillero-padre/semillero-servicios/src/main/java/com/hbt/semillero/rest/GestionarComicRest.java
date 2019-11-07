/**
 * GestionarComicRest.java
 */
package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
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

}// Cierre de la clase
