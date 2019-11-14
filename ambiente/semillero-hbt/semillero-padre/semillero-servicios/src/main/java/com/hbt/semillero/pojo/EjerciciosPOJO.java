/**
 * EjerciciosPojo.java
 */
package com.hbt.semillero.pojo;

import java.time.LocalDate;
import java.time.Period;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
 * @version 
 */
public class EjerciciosPOJO {

	/**
	 * 
	 * Metodo encargado de no son validos: true - java.lang - 1980_s
	 * <b>Caso de Uso</b>
	 * @author camil
	 * 
	 * @param identificador
	 * @return
	 */
	public boolean ejercicio1(String identificador) {
		//if(identificador != null && identificador.charAt(0))
		return false;
	}
	
	/**
	 * 
	 * Metodo encargado de verfiicar si un numero es primo
	 * <b>Caso de Uso</b>
	 * 
	 * @param numero
	 * @return true si es primo, false si no lo es
	 */
	public boolean ejercicio3 (int numero) {
		int contador = 0;
		
		for (int i = 1; i <= numero; i++) {
			if(numero%i == 0) {
				contador++;
			}
		}
		if(contador == 2) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 
	 * Metodo encargado de validar si es igual a la fecha de hoy
	 * <b>Caso de Uso</b>
	 * 
	 * @return
	 */
	public Period ejercicio4(LocalDate fechaNacimiento) {
		
		LocalDate fechaActual = LocalDate.now();
		
		Period periodo = Period.between(fechaNacimiento, fechaActual);
		
		return periodo;
	}
	
}//Cierre de la clase
