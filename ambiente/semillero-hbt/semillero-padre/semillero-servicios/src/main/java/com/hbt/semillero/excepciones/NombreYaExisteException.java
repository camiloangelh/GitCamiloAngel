package com.hbt.semillero.excepciones;

/**
 * Clase que representa la excepcion NombreYaExisteException
 * 
 * @author Camilo Angel Hurtado
 *
 */
public class NombreYaExisteException extends Exception {

	/**
	 * Atributo que representa serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo que representa el mensaje de la excepcion
	 */
	private String mensaje;

	/**
	 * Constructor de la clase
	 */
	public NombreYaExisteException() {
		this.mensaje = "El nombre ya existe, debe ser unico";
	}

	/**
	 * Metodo que permite obtener el mensaje asociado a la clase
	 * 
	 * @return mensaje de la clase
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * Metodo que permite modificar el mensaje
	 * 
	 * @param mensaje nuevo a modificar
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}// Cierre de la clase
