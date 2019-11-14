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
	 * Variable que almacena numeros
	 */
	int [] arreglo = new int [4];
	int indice = 0;
	
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
	
	/**
	 * 
	 * Metodo encargado de realizar el ejercicio 5, ordendar menor a mayor
	 * <b>Caso de Uso</b>
	 * @author camil
	 *
	 */
	public int [] ejercicio5 () {
		int menor;
		for (int i = 0; i < arreglo.length; i++) {
			for (int j = 0; j < arreglo.length-i-1; j++) {
				if(arreglo[j] > arreglo[j+1]) {
						menor = arreglo[j+1];
						arreglo[j+1] = arreglo[j];
						arreglo[j] = menor;
					
				}
			}
		}
		return arreglo;
	}
	
	/**
	 * 
	 * Metodo encargado de llenar el arreglo 
	 * <b>Caso de Uso</b>
	 * @author camil
	 * 
	 * @param numeroIngresar
	 */
	public void llenarArreglo(int numeroIngresar) {
		arreglo[indice] = numeroIngresar;
		indice++;
	}
	
	/**
	 * 
	 * Metodo encargado de realizar el ejercicio 7, llegue tarde :/
	 * <b>Caso de Uso</b>
	 * @author camil
	 *
	 */
	public void ejercicio7() {
		
	}
	
	/**
	 * 
	 * Metodo encargado de realizar el ejercicio 8
	 * <b>Caso de Uso</b>
	 * @author camil
	 *
	 */
	public String ejercicio8(int pedido) {
		int moneda1000=0, moneda500=0, moneda200=0, moneda100=0, moneda50=0;
		while(pedido > 1000) {
			moneda1000++;
			pedido = pedido - 1000;
		}
		while(pedido > 500) {
			moneda500++;
			pedido = pedido - 500;
		}
		while(pedido > 200) {
			moneda200++;
			pedido = pedido - 200;
		}
		while(pedido > 100) {
			moneda100++;
			pedido = pedido - 100;
		}
		while(pedido >= 50) {
			moneda50++;
			pedido = pedido - 50;
		}
		return "Moneda 1000: " + moneda1000 + "Moneda 500: " + moneda500 + "Moneda 200: " + moneda200 + "Moneda 100: " + moneda100 + "Moneda 50: " + moneda50;
	}
	
}//Cierre de la clase
