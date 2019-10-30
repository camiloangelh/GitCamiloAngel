/**
 * GestionarComicPOJO.java
 */
package com.hbt.semillero.pojo;

import java.util.List;

import com.hbt.semillero.dto.ComicDTO;

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

	// TODO Continuar llenado ComicDTO para la sesion del jueves
	public void crearComicDTO() {
		ComicDTO comicDTO = new ComicDTO();
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
