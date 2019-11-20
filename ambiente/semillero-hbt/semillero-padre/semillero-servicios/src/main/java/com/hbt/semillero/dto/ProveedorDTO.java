package com.hbt.semillero.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.hbt.semillero.entidades.EstadoProveedorEnum;

/**
 * Clase que determina los datos de un proveedor
 * 
 * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
 *
 */
public class ProveedorDTO implements Serializable {

	/**
	 * Atributo que determina serialVersionUID
	 */
	private static final long serialVersionUID = 5421733469758671175L;

	/**
	 * Atributo que determina el identificador del proveedor
	 */
	private Long id;

	/**
	 * Atributo que determina el nombre del proveedor
	 */
	private String nombre;

	/**
	 * Atributo que determina la direccion del proveedor
	 */
	private String direccion;

	/**
	 * Atributo que determina la fecha de creacion del proveedor
	 */
	private LocalDate fechaCreacion;

	/**
	 * Atributo que indica el estado en el que se encuentra el proveedor
	 */
	private EstadoProveedorEnum estadoProveedorEnum;

	/**
	 * Atributo que indica el valor en el que se encuentra el credito con el
	 * proveedor
	 */
	private BigDecimal montoCredito;

	// --------------------------------- CONSTRUCTOR ---------------------------

	/**
	 * Constructor vacio de la clase
	 */
	public ProveedorDTO() {

	}

	/**
	 * Constructor con todos los atributos de la clase
	 * 
	 * @param id
	 * @param nombre
	 * @param direccion
	 * @param fechaCreacion
	 * @param estadoProveedorEnum
	 * @param montoCredito
	 */
	public ProveedorDTO(Long id, String nombre, String direccion, LocalDate fechaCreacion,
			EstadoProveedorEnum estadoProveedorEnum, BigDecimal montoCredito) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.fechaCreacion = fechaCreacion;
		this.estadoProveedorEnum = estadoProveedorEnum;
		this.montoCredito = montoCredito;
	}

	// -------------------------------- GETS AND SETS --------------------------

	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * 
	 * @return El id asociado a la clase
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Metodo encargado de modificar el valor del atibuto id
	 * 
	 * @param id nuevo a modificar
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo encargado de retornar el nombre del proveedor
	 * 
	 * @return el nombre del proveedor
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo encargado de modificar el nombre del proveedor
	 * 
	 * @param nombre nuevo a modificar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo direccion
	 * 
	 * @return la direccion asociada a la clase
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Metodo encargado de modificar la direccion
	 * 
	 * @param direccion nueva a modificar
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Metodo encargado de retornar la fecha de creacion
	 * 
	 * @return la fecha de creacion asociado a la clase
	 */
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Metodo encagado de modificar la fecha de creacion
	 * 
	 * @param fechaCreacion nueva a modificar
	 */
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * Metodo encargado de retornar el estado del proveedor
	 * 
	 * @return el estado asociado a la clase
	 */
	@Enumerated(value = EnumType.STRING)
	public EstadoProveedorEnum getEstadoProveedorEnum() {
		return estadoProveedorEnum;
	}

	/**
	 * Metodo encargado de modificar el estado del proveedor
	 * 
	 * @param estadoProveedorEnum nuevo a modificar
	 */
	public void setEstadoProveedorEnum(EstadoProveedorEnum estadoProveedorEnum) {
		this.estadoProveedorEnum = estadoProveedorEnum;
	}

	/**
	 * Metodo que retorna el monto de credito
	 * 
	 * @return el monto de credito asociado a la clase
	 */
	public BigDecimal getMontoCredito() {
		return montoCredito;
	}

	/**
	 * Metodo que permite modificar el monto del credito
	 * 
	 * @param montoCredito nuevo a modificar
	 */
	public void setMontoCredito(BigDecimal montoCredito) {
		this.montoCredito = montoCredito;
	}

}// Cierre de la clase
