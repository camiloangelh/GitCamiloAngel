package com.hbt.semillero.entidades;

/**
 * Clase que representa el estado en el que se encuentra un proveedor
 * 
 * @author Camilo Angel Hurtado
 *
 */
public enum EstadoProveedorEnum {

	ACTIVO("enum.estado.activo"), INACTIVO("enum.estado.inactivo");

	/**
	 * Variable que representa la descripcion del estado
	 */
	private String codigoMensaje;

	/**
	 * Constructor de la clase
	 * 
	 * @param codigoMensaje
	 */
	private EstadoProveedorEnum(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo codigoMensaje
	 * 
	 * @return El codigoMensaje asociado a la clase
	 */
	public String getCodigoMensaje() {
		return codigoMensaje;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo codigoMensaje
	 * 
	 * @param codigoMensaje El nuevo codigoMensaje a modificar.
	 */
	public void setCodigoMensaje(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}

}// Cierre de la clase
