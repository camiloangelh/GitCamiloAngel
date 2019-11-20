package com.hbt.semillero.excepciones;

/**
 * Clase que indica que ya esta el maximo de proveedores
 * 
 * @author camil
 *
 */
public class MaximoProveedoresException extends Exception {

	/**
	 * Atributo que representa serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo que representa el mensaje asociado a la clase
	 */
	private String mensaje;

	/**
	 * Constructor vacio de la clase
	 */
	public MaximoProveedoresException() {

	}

	/**
	 * Constructor con atributos de la clase
	 * 
	 * @param mensaje
	 */
	public MaximoProveedoresException(String mensaje) {
		this.mensaje = mensaje;
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

}
