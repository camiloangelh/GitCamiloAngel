/**
 * GestionarComicPOJO.java
 */
package com.hbt.semillero.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author cangelh
 * @version
 */
public class GestionarComicPOJO {

	/**
	 * Variable que representa la lista de comics
	 */
	private List<ComicDTO> listaComics = null;

	/**
	 * 
	 * Metodo encargado de crear un comicDTO <b>Caso de Uso</b>
	 * 
	 * 
	 * @param id
	 * @param nombre
	 * @param editorial
	 * @param tematicaEnum
	 * @param coleccion
	 * @param numeroPaginas
	 * @param precio
	 * @param autores
	 * @param color
	 * @param fechaVenta
	 * @param estadoEnum
	 * @param cantidad
	 * @return el objeto tipo ComicDTO inicializado
	 */
	public ComicDTO crearComicDTO(String id, String nombre, String editorial, TematicaEnum tematicaEnum,
			String coleccion, Integer numeroPaginas, BigDecimal precio, String autores, Boolean color,
			LocalDate fechaVenta, EstadoEnum estadoEnum, Long cantidad) {

		ComicDTO comicDTO = new ComicDTO(id, nombre, editorial, tematicaEnum, coleccion, numeroPaginas, precio, autores,
				color, fechaVenta, estadoEnum, cantidad);

		return comicDTO;
	}

	/**
	 * 
	 * Metodo encargado de crear un comicDTO <b>Caso de Uso</b>
	 * 
	 * @param comicDTO
	 * @return
	 */
	public ComicDTO crearComicDTO(ComicDTO comicDTO) {
		return comicDTO;
	}

	/**
	 * 
	 * Metodo encargado de agregar un comicDTO a lista de comics <b>Caso de Uso</b>
	 * 
	 * @author camil
	 * 
	 * @param comicDTO
	 */
	public void agregarComicDTOLista(ComicDTO comicDTO) {
		if (listaComics == null) {
			listaComics = new ArrayList<ComicDTO>();
		}
		listaComics.add(comicDTO);

	}

	/**
	 * 
	 * Metodo encargado de modificar un Comic de la lista de comics <b>Caso de
	 * Uso</b>
	 * 
	 * 
	 * @param i
	 * @param comicDTO
	 */
	public void modificarComicDTO(int i, ComicDTO comicDTO) {
		listaComics.set(i, comicDTO);
	}

	/**
	 * 
	 * Metodo encargado de crear un comicDTO <b>Caso de Uso</b>
	 *
	 */
	public void crearComicDTO() {
		ComicDTO comicDTO = new ComicDTO();
		comicDTO.setId("100");
		comicDTO.setNombre("Dragon Ball Yamcha");
		comicDTO.setEditorial("Planeta Cómic");
		comicDTO.setTematica(TematicaEnum.AVENTURAS);
		comicDTO.setColeccion("Manga Shonen");
		comicDTO.setNumeroPaginas(144);
		comicDTO.setPrecio(new BigDecimal(2100));
		comicDTO.setAutores("Dragon Garow Lee");
		comicDTO.setColor(Boolean.FALSE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstado(EstadoEnum.ACTIVO);
		comicDTO.setCantidad(20L);

		if (listaComics == null) {
			listaComics = new ArrayList<ComicDTO>();
		}

		listaComics.add(comicDTO);
	}

	/**
	 * 
	 * Metodo encargado de modificar un comic <b>Caso de Uso</b>
	 * 
	 * @param nombre
	 */
	public void modificarComicDTO(String id, String nombre) {
		ComicDTO comicModificar = null;
		for (int i = 0; i < listaComics.size(); i++) {
			comicModificar = listaComics.get(i);
			if (comicModificar.getId().equals(id)) {
				comicModificar.setNombre(nombre);
				return;
			}
		}
	}

	/**
	 * 
	 * Metodo encargado de eliminar un comicDTO de la lista de comics <b>Caso de
	 * Uso</b>
	 * 
	 * @param id
	 */
	public void eliminarComic(String id) {
		int i = 0;
		ComicDTO comicEliminar = null;
		while (i < listaComics.size()) {
			comicEliminar = listaComics.get(i);

			if (comicEliminar.getId().equals(id)) {
				listaComics.remove(comicEliminar);
				return;
			}

			i++;
		}
	}

	/**
	 * Metodo encargado de retornar el valor del atributo listaComics
	 * 
	 * @return El listaComics asociado a la clase
	 */
	public List<ComicDTO> getListaComics() {
		return listaComics;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaComics
	 * 
	 * @param listaComics El nuevo listaComics a modificar.
	 */
	public void setListaComics(List<ComicDTO> listaComics) {
		this.listaComics = listaComics;
	}

}// Cierre de la clase
