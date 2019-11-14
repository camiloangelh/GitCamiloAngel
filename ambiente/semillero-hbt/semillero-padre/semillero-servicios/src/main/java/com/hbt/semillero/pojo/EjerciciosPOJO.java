/**
 * EjerciciosPojo.java
 */
package com.hbt.semillero.pojo;

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
	
}//Cierre de la clase
