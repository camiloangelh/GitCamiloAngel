/**
 * EjerciciosPOJOTest.java
 */
package com.hbt.semillero.servicios;

import java.time.LocalDate;
import java.time.Period;

import org.hibernate.type.descriptor.java.LocalDateJavaDescriptor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.pojo.EjerciciosPOJO;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
 * @version 
 */
public class EjerciciosTest {

	/**
	 * Variable que permite usar los metodos de ejerciciosPOJO
	 */
	private EjerciciosPOJO ejerciciosPOJO = new EjerciciosPOJO();
	
	
	private String brand;

	private boolean empty;

	public static void ejercicio2Test() {

		//System.out.print("Empty = " + empty);
		//System.out.print(", Brand = " + brand);
	}
	
	/**
	 * 
	 * Metodo encargado de hacer la prueba del ejercicio 3
	 * <b>Caso de Uso</b>
	 *
	 */
	@Test(enabled = false)
	public void ejercicio3Test() {
		Assert.assertTrue(ejerciciosPOJO.ejercicio3(5));
		Assert.assertTrue(ejerciciosPOJO.ejercicio3(222));
		Assert.assertTrue(ejerciciosPOJO.ejercicio3(0));
	}
	
	/**
	 * 
	 * Metodo encargado de probar el ejercicio 4
	 * <b>Caso de Uso</b>
	 * @author camil
	 *
	 */
	@Test(enabled = false)
	public void ejercicio4Test() {
		Period periodo = ejerciciosPOJO.ejercicio4(LocalDate.parse("1997/05/17"));
		Assert.assertEquals(periodo.getYears(), LocalDate.now().getYear());
	}
	
	/**
	 * 
	 * Metodo encargado de probar el ejercicio 5
	 * <b>Caso de Uso</b>
	 * @author camil
	 *
	 */
	@Test(enabled = false)
	public void ejercicio5Test() {
		ejerciciosPOJO.llenarArreglo(50);
		ejerciciosPOJO.llenarArreglo(1);
		ejerciciosPOJO.llenarArreglo(249);
		ejerciciosPOJO.llenarArreglo(-2);
		int [] arregloTest = {-2, 1,  50, 249};
		int [] arregloOrdenado = ejerciciosPOJO.ejercicio5();
		Assert.assertEquals(arregloTest, arregloOrdenado);
	}
	
	/**
	 * 
	 * Metodo encargado de probar el ejercicio 7
	 * <b>Caso de Uso</b>
	 * @author camil
	 *
	 */
	@Test(enabled = false)
	public void ejercicio7Test() {
		
	}
	
	/**
	 * 
	 * Metodo encargado de probar el ejercicio 8, devolver monedas
	 * <b>Caso de Uso</b>
	 * @author camil
	 *
	 */
	@Test(enabled = false)
	public void ejercicio8Test() {
		String mensajeValido1000 = "Moneda 1000: " + 1 + "Moneda 500: " + 0 + "Moneda 200: " + 0 + "Moneda 100: " + 0 + "Moneda 50: " + 0;

		String mensajeValido5550 = "Moneda 1000: " + 5 + "Moneda 500: " + 1 + "Moneda 200: " + 0 + "Moneda 100: " + 0 + "Moneda 50: " + 1;
		Assert.assertEquals(mensajeValido5550, ejerciciosPOJO.ejercicio8(5550));
		Assert.assertEquals(mensajeValido1000, ejerciciosPOJO.ejercicio8(1000));
	}
	
	
	/**
	 * 
	 * Metodo encargado de probar el ejercicio 11
	 * <b>Caso de Uso</b>
	 * @author camil
	 *
	 */
	@Test
	public void ejercicio11Test() {
		String siguiente = "19";
		Assert.assertEquals(siguiente, ejerciciosPOJO.ejercicio11(1, 9));
		
	}
	
}//Cierre de la clase
