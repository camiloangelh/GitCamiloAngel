package com.hbt.semillero.ejb;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.excepciones.MaximoProveedoresException;
import com.hbt.semillero.excepciones.NoExistenRegistrosException;
import com.hbt.semillero.excepciones.NombreYaExisteException;

/**
 * Expone los métodos del EJB GestionarComic Las interfaces determinan una
 * especie de contrato donde se define las firmas de los metodos, define que se
 * necesita implementar pero no el como eso lo realiza la clase que la
 * implementa Palabras claves interface e implements
 * 
 * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
 *
 */
@Local
public interface IGestionarProveedorLocal {

	/**
	 * Metodo que permite crear un proveedor
	 * 
	 * @param proveedorDTO informacion nueva a crear
	 * @throws NombreYaExisteException
	 * @throws NoExistenRegistrosException
	 * @throws MaximoProveedoresException 
	 */
	public void crearProveedor(ProveedorDTO proveedorDTO) throws NombreYaExisteException, NoExistenRegistrosException, MaximoProveedoresException;

	/**
	 * Metodo que permite obtener la lista de proveedores
	 * 
	 * @return lista de proveedores
	 * @throws NoExistenRegistrosException
	 */
	public List<ProveedorDTO> consultarProveedores() throws NoExistenRegistrosException;

	/**
	 * Metodo que permite consultar un proveedor por su id
	 * 
	 * @param id identificador del proveedor a ser consultado
	 * @return
	 * @throws NoExistenRegistrosException
	 */
	public ProveedorDTO consultarProveedorPorId(String id) throws NoExistenRegistrosException;

	/**
	 * Metodo que permite consultar un proveedor por su nombre
	 * 
	 * @param nombre del proveedor a ser consultado
	 * @return el proveedor consultado
	 */
	public ProveedorDTO consultarProveedorPorNombre(String nombre);

	/**
	 * Metodo que permite modificar el nombre de un proveedor a partir de su id
	 * 
	 * @param id          identificador del proveedor a ser modificado
	 * @param nombreNuevo El nuevo valor del nombre
	 * @throws NoExistenRegistrosException
	 */
	public void modificarNombre(String id, String nombreNuevo) throws NoExistenRegistrosException;

	/**
	 * Metodo que permite modificar el monto del credito del proveedor
	 * 
	 * @param id         del proveedor a ser modificado
	 * @param montoNuevo El nuevo valor del monto del credito
	 * @throws NoExistenRegistrosException
	 */
	public void modificarMontoCredito(String id, BigDecimal montoNuevo) throws NoExistenRegistrosException;

	/**
	 * Metodo que permite eliminar un proveedor a partir de su id, por reglas de
	 * negocio solo se cambia el estado del proveedor a inactivo. No debe ser
	 * eliminado de la BD's
	 * 
	 * @param id El identificador del proveedor
	 * @throws NoExistenRegistrosException
	 */
	public void eliminarProveedor(String id) throws NoExistenRegistrosException;

	/**
	 * Metodo que notifica cuando el credito esta proximo a coparse
	 * 
	 * @param idProveedor identificador del proveedor a notificar
	 * @return true si esta cerca a coparse, false en caso contrario
	 * @throws NoExistenRegistrosException
	 */
	public Boolean notificarCreditoProximoCoparse(String idProveedor) throws NoExistenRegistrosException;

	/**
	 * Metodo que notifica cuando el contrato esta en vigencia con el proveedor
	 * 
	 * @param idProveedor identificador del proveedor
	 * @return true si el contrato aun es vigente, false en caso contrario
	 * @throws NoExistenRegistrosException
	 */
	public Boolean notificarVigenciaContrato(String idProveedor) throws NoExistenRegistrosException;

	/**
	 * Metodo que calcula la cantidad de proveedores activos
	 * 
	 * @return cantidad de proveedor activos
	 * @throws NoExistenRegistrosException
	 */
	public Boolean calcularCantidadProveedoresActivos() throws NoExistenRegistrosException;

}// Cierre de la clase
