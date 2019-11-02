/**
 * GestionarComicBean.java
 */
package com.hbt.semillero.ejb;

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
public class GestionarComicBean {

	/**
	 * Variable que permitira la comunicacion con la base de datos
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * 
	 * Metodo encargado de crear un comic y almacenarlo en la base de datos <b>Caso
	 * de Uso</b>
	 * 
	 * @param comicDTO
	 */
	// TODO Agregar interfaz
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		comic.setId(comicDTO.getId());
		comic.setNombre(comicDTO.getNombre());
		comic.setEditorial(comicDTO.getEditorial());
		comic.setTematicaEnum(comicDTO.getTematica());
		comic.setColeccion(comicDTO.getColeccion());
		comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
		comic.setPrecio(comicDTO.getPrecio());
		comic.setAutores(comicDTO.getAutores());
		comic.setColor(comicDTO.getColor());
		comic.setFechaVenta(comicDTO.getFechaVenta());
		comic.setEstadoEnum(comicDTO.getEstado());
		comic.setCantidad(comicDTO.getCantidad());

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
		comic.setId(comicModificar.getId());
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
	 * 
	 * Metodo encargado de consultar un comic a partir de su id
	 * 
	 * @param id
	 * @return el comic consultado
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO consultarComic(String id) {
		Comic comic = entityManager.find(Comic.class, id);
		ComicDTO comicDTO = new ComicDTO(comic.getId(), comic.getNombre());
		return comicDTO;
	}
	
	public List<ComicDTO> consultarTodos(){
		List <Comic> resultados = (List<Comic>) entityManager.createQuery("select c from Comic").getResultList();
		
		return null;
	}

}// Cierre de la clase
