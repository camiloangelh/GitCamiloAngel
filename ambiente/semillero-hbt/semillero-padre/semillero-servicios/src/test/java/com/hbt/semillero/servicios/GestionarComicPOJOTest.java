/**
 * GestionarComicPOJOTest.java
 */
package com.hbt.semillero.servicios;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;
import com.hbt.semillero.pojo.GestionarComicPOJO;

/**
 * <b>Descripción:<b> Clase que determina las pruebas de la clase ComicDTO
 * <b>Caso de Uso:<b>
 * 
 * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
 * @version
 */
public class GestionarComicPOJOTest {

	/**
	 * Variable que permite validar la clase gestionarComicPOJO
	 */
	GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();

	/**
	 * Metodo para validar el metodo crearComicDTO Metodo encargado de <b>Caso de
	 * Uso</b>
	 * 
	 *
	 */
	@Test(enabled = false)
	public void crearComicDTOTest() {
		GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();
		gestionarComicPOJO.crearComicDTO();

		Assert.assertNotNull(gestionarComicPOJO.getListaComics());

		Assert.assertTrue(!gestionarComicPOJO.getListaComics().isEmpty());
	}

	/**
	 * 
	 * Metodo encargado de validar el metodo crearComic <b>Caso de Uso</b>
	 * 
	 * @author camil
	 *
	 */
	@Test
	public void creartComicDTOTest() {
		gestionarComicPOJO = new GestionarComicPOJO();
		ComicDTO comicDTO = new ComicDTO("2", "Captain America Corps 1-5 USA", "Panini Comics", TematicaEnum.FANTASTICO,
				"BIBLIOTECA MARVEL", 128, new BigDecimal(5000), "Phillippe Briones, Roger Stern", Boolean.FALSE,
				LocalDate.now(), EstadoEnum.ACTIVO, 5L);

		gestionarComicPOJO.agregarComicDTOLista(comicDTO);

		Assert.assertNotNull(gestionarComicPOJO.getListaComics());

		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() >= 1);

		comicDTO = new ComicDTO();
		comicDTO.setId("1");
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
		gestionarComicPOJO.agregarComicDTOLista(comicDTO);
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 2);

		comicDTO = new ComicDTO();
		comicDTO.setId("3");
		comicDTO.setNombre("The Spectacular Spider-Man v2 USA");
		comicDTO.setEditorial("Panini Comics ");
		comicDTO.setTematica(TematicaEnum.FANTASTICO);
		comicDTO.setColeccion("MARVEL COMICS");
		comicDTO.setNumeroPaginas(208);
		comicDTO.setPrecio(new BigDecimal(6225));
		comicDTO.setAutores("Straczynski,Deodato Jr.,Barnes,Eaton");
		comicDTO.setColor(Boolean.TRUE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstado(EstadoEnum.INACTIVO);
		comicDTO.setCantidad(0L);
		gestionarComicPOJO.agregarComicDTOLista(comicDTO);
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 3);

	}

	/**
	 * 
	 * Metodo encargado de validar el metodo modificar comicDTO <b>Caso de Uso</b>
	 * 
	 * @author camil
	 *
	 */
	@Test
	public void modificarComicDTOTest() {
		String nombreNuevo = "Captain America";
		// Se modifica el comic con id 2
		gestionarComicPOJO.modificarComicDTO("2", nombreNuevo);
		Assert.assertEquals(nombreNuevo, gestionarComicPOJO.getListaComics().get(0).getNombre());
		Assert.assertNotEquals("Captain America Corps 1-5 USA", gestionarComicPOJO.getListaComics().get(0).getNombre());
	}

	/**
	 * 
	 * Metodo encargado de validar el metodo eliminarComicDTO <b>Caso de Uso</b>
	 * 
	 * @author camil
	 *
	 */
	@Test
	public void eliminarComicDTOTest() {
		// Se elimina el comic con el id 1
		gestionarComicPOJO.eliminarComic("1");

		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 2);
	}

	// TODO Preguntar a Cindy en la siguiente clase
	@Test
	public void agregarComicDTOListaTest() {

	}

}// Cierre de la clase
