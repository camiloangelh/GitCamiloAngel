/**
 * EjerciciosPOJOTest.java
 */
package com.hbt.semillero.servicios;

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

	
	private EjerciciosPOJO ejerciciosPOJO = new EjerciciosPOJO();
	
	private String brand;

	private boolean empty;

	public static void ejercicio2Test() {

		//System.out.print("Empty = " + empty);
		//System.out.print(", Brand = " + brand);
	}
	
	@Test
	public void ejercicio3Test() {
		Assert.assertTrue(ejerciciosPOJO.ejercicio3(5));
		Assert.assertTrue(ejerciciosPOJO.ejercicio3(222));
		Assert.assertTrue(ejerciciosPOJO.ejercicio3(0));
	}
	
	
}//Cierre de la clase
