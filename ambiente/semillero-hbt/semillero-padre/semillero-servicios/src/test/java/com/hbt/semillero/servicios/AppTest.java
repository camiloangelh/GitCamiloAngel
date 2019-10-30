package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;


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
	
	//TODO
	/**
	 * Hacer un metodo que use el metodo toString de la entidad Comic
	 */

}// Cierre de la clase
