package com.hbt.semillero.excepciones;

/**
 * Clase Exception que indica que no se encontraron registros en la tabla
 * 
 * @author Camilo Angel Hurtado
 *
 */
public class NoExistenRegistrosException extends Exception {

	/**
	 * Atributo que representa serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo que representa el mensaje de la excepcion
	 */
	private String mensaje;

	/**
	 * Constructor vacio de la clase
	 */
	public NoExistenRegistrosException() {
	}

	/**
	 * Constructor con atributo de la clase
	 */
	public NoExistenRegistrosException(String mensaje) {
		this.setMensaje(mensaje);
	}

	/**
	 * Metodo que permite obtener el mensaje de la clase
	 * 
	 * @return mensaje asociado a la clase
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * Metodo que permite modificar el mensaje
	 * 
	 * @param mensaje nuevo a modficar
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}// Cierre de la clase
