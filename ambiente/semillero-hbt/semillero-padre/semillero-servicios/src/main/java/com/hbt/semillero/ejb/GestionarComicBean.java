/**
 * GestionarComicBean.java
 */
package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @version
 */
@Stateless
public class GestionarComicBean implements IGestionarComicLocal {

	/**
	 * Variable que permitira la comunicacion con la base de datos
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * 
	 * Metodo encargado de consultar un comic a partir de su id
	 * 
	 * @param id
	 * @return el comic consultado
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO consultarComic(String id) {
		Comic comic = entityManager.find(Comic.class, id);
		ComicDTO comicDTO = convertirComicToComicDTO(comic);
		return comicDTO;
	}

	/**
	 * 
	 * Metodo encargado de crear un comic y almacenarlo en la base de datos <b>Caso
	 * de Uso</b>
	 * 
	 * @param comicDTO
	 */
	// TODO Agregar interface
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW) // Tengo conversacion activa? se crea una transaccion
																	// nueva.
	public void crearComic(ComicDTO comicDTO) {
		Comic comic = convertirComicDTOToComic(comicDTO);

		entityManager.persist(comic);
	}

	/**
	 * 
	 * Metodo encargado de modificar la informacion de un comic <b>Caso de Uso</b>
	 * 
	 * @author camil
	 * 
	 * @param comicDTO
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarComic(ComicDTO comicModificar) {
		Comic comic = new Comic();
		comic.setId(Long.parseLong(comicModificar.getId()));
		comic.setNombre(comicModificar.getNombre());
		comic.setEditorial(comicModificar.getEditorial());
		comic.setTematicaEnum(comicModificar.getTematica());
		comic.setColeccion(comicModificar.getColeccion());
		comic.setNumeroPaginas(comicModificar.getNumeroPaginas());
		comic.setPrecio(comicModificar.getPrecio());
		comic.setAutores(comicModificar.getAutores());
		comic.setColor(comicModificar.getColor());
		comic.setFechaVenta(comicModificar.getFechaVenta());
		comic.setEstadoEnum(comicModificar.getEstado());
		comic.setCantidad(comicModificar.getCantidad());
		entityManager.merge(comic);
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#modificarComic(java.lang.Long,
	 *      java.lang.String, com.hbt.semillero.dto.ComicDTO)
	 */
	@Override
	// @TransactionAttribute(TransactionAttributeType.REQUIRED)
	// TODO Cual es el resultado de llamar modificarComic
	public void modificarComic(Long id, String nombre, ComicDTO comicNuevo) {
		Comic comicModificar;
		if (comicNuevo == null) {
			comicModificar = entityManager.find(Comic.class, id);
		} else {
			comicModificar = convertirComicDTOToComic(comicNuevo);

		} // TODO Validar si comicModificar llego con datos
		comicModificar.setNombre(nombre);
		// Si no encuentra en la base de dato actualiza si no inserta
		entityManager.merge(comicModificar);
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#eliminarComic(java.lang.Long)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarComic(Long idComic) {
		if (idComic != null) {
			ComicDTO comicDTOEliminar = consultarComic(idComic.toString());
			if (comicDTOEliminar != null) {
				Comic comicEliminar = convertirComicDTOToComic(comicDTOEliminar);
				entityManager.remove(comicEliminar);
			}
		}
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarComics()
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarComics() {
		// TODO Hacer que la lista de resultados sea igual a nula
		List<ComicDTO> resultadoComicsDTO = new ArrayList<ComicDTO>();
		List<Comic> resultadoComics = entityManager.createQuery("select c from Comic c").getResultList();
		// Se valida que la lista tenga comics almacenados
		if (resultadoComics.size() > 0) {
			for (Comic comic : resultadoComics) {
				resultadoComicsDTO.add(convertirComicToComicDTO(comic));
			}
		}
		return resultadoComicsDTO;
	}

	/**
	 * 
	 * Metodo encargado de convertir un comicDTO en comic <b>Caso de Uso</b>
	 * 
	 * @param comicDTO
	 * @return objeto de tipo Comic
	 */
	private Comic convertirComicDTOToComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		if (comicDTO.getId() != null) {
			comic.setId(Long.parseLong(comicDTO.getId()));
		}
		comic.setNombre(comicDTO.getNombre());
		comic.setEditorial(comicDTO.getEditorial());
		comic.setTematicaEnum(comicDTO.getTematicaEnum());
		comic.setColeccion(comicDTO.getColeccion());
		comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
		comic.setPrecio(comicDTO.getPrecio());
		comic.setAutores(comicDTO.getAutores());
		comic.setColor(comicDTO.getColor());
		comic.setFechaVenta(comicDTO.getFechaVenta());
		comic.setEstadoEnum(comicDTO.getEstado());
		comic.setCantidad(comicDTO.getCantidad());
		return comic;
	}

	/**
	 * 
	 * Metodo encargado de convertir un Comic en un objeto ComicDTO
	 * 
	 * @param comic
	 * @return objeto de tipo ComicDTO
	 */
	private ComicDTO convertirComicToComicDTO(Comic comic) {
		ComicDTO comicDTO = new ComicDTO();
		if (comic.getId() != null) {
			comicDTO.setId(String.valueOf(comic.getId()));
		}
		comicDTO.setNombre(comic.getNombre());
		comicDTO.setEditorial(comic.getEditorial());
		comicDTO.setTematica(comic.getTematicaEnum());
		comicDTO.setColeccion(comic.getColeccion());
		comicDTO.setNumeroPaginas(comic.getNumeroPaginas());
		comicDTO.setPrecio(comic.getPrecio());
		comicDTO.setAutores(comic.getAutores());
		comicDTO.setColor(comic.getColor());
		comicDTO.setFechaVenta(comic.getFechaVenta());
		comicDTO.setEstado(comic.getEstadoEnum());
		comicDTO.setCantidad(comic.getCantidad());
		return comicDTO;
	}

}// Cierre de la clase
