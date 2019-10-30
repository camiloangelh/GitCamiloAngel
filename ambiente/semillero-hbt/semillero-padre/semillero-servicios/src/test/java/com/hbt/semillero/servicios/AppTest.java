package com.hbt.semillero.servicios;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.entidades.Comic;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;

/**
 * Clase donde se hacen las pruebas unitarias
 *
 */
public class AppTest {

	public void shouldAnswerWithTrue() {

	}

	/**
	 * Metodo para invertir cadena
	 * 
	 * @param cadena
	 * @return cadena invertida
	 */
	private String invertirCadena(String cadena) {

		String cadenaInvertida = "";

		for (int x = cadena.length() - 1; x >= 0; x--) {

			cadenaInvertida = cadenaInvertida + cadena.charAt(x);
		}

		return cadenaInvertida;
	}

	@Test
	public void primeraPrueba() {
		Long resultadoEsperado = 150L;
		Long sumando1 = 100L;
		Long sumando2 = 50L;
		Long resultado = sumando1 + sumando2;

		Assert.assertEquals(resultado, resultadoEsperado);
		resultadoEsperado = 200L;
		Assert.assertNotEquals(resultado, resultadoEsperado);

	}

	/**
	 * Valida el metodo invertirCadena()
	 */
	@Test
	public void validarInvertirCadena() {
		String cadena = "prueba";
		String cadenaEsperada = "abeurp";
		String cadenaInvertida = invertirCadena(cadena);

		Assert.assertEquals(cadenaEsperada, cadenaInvertida);

		Assert.assertNotEquals(cadena, cadenaEsperada);

//		Debe generar error
//		Assert.assertEquals(cadena, cadenaInvertida);

	}

	/**
	 * 
	 * Metodo encargado de validar el estado de la clase EstadoEnum <b>Caso de
	 * Uso</b>
	 *
	 */
	@Test
	public void validarEstado() {
		EstadoEnum estadoActivo = EstadoEnum.ACTIVO;

		// Devolver un String con el nombre de la constante (ACTIVO)
		System.out.println("Estado activo name > " + estadoActivo.name());

		// Devolver un String con el nombre de la constante (ACTIVO)
		System.out.println("Estado activo toString " + estadoActivo.toString());

		// Devolver un entero con la posición del enum según está declarada
		System.out.println("Posicion del Enum segun esta declarado >" + estadoActivo.ordinal());

		// Comparar el enum con el parámetro según el orden en el que están declarados
		EstadoEnum estadoInactivo = EstadoEnum.INACTIVO;
		System.out.println(estadoActivo.compareTo(estadoInactivo));

		// Devolver un array que contiene todos los enum
		for (EstadoEnum listaEstadoEnum : EstadoEnum.values()) {
			System.out.println(listaEstadoEnum.toString() + " - ");
		}
	}

	// TODO
	/**
	 * Hacer un metodo que use el metodo toString de la entidad Comic
	 */
	@Test
	public void validarToStringComic() {
		Comic comic = new Comic();
		comic.setId("1");
		comic.setNombre("Batman Return");
		comic.setEditorial("DC Comics");
		comic.setTematicaEnum(TematicaEnum.BELICO);
		comic.setColeccion("Batman Return");
		comic.setNumeroPaginas(68);
		comic.setPrecio(new BigDecimal("80000"));
		comic.setAutores("Sam Hamm");
		comic.setColor(true);
		comic.setFechaVenta(LocalDate.now());
		comic.setEstadoEnum(EstadoEnum.ACTIVO);
		comic.setCantidad(5L);

		System.out.println(comic.toString());
	}

}// Cierre de la clase
