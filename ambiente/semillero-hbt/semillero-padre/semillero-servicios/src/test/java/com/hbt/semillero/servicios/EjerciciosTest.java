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
	@Test
	public void ejercicio4Test() {
		Period periodo = ejerciciosPOJO.ejercicio4(LocalDate.parse("1997/05/17"));
		Assert.assertEquals(periodo.getYears(), LocalDate.now().getYear());
	}
	
	
}//Cierre de la clase
