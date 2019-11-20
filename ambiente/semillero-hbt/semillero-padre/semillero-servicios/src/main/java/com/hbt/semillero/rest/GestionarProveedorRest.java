package com.hbt.semillero.rest;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarProveedorLocal;
import com.hbt.semillero.excepciones.MaximoProveedoresException;
import com.hbt.semillero.excepciones.NoExistenRegistrosException;
import com.hbt.semillero.excepciones.NombreYaExisteException;

/**
 * Clase que permite gestionar los servicios rest de la clase proveedor
 * 
 * @author Camilo Angel Hurtado
 *
 */
@Path("/GestionarProveedor")
public class GestionarProveedorRest {

	/**
	 * Variable que permite gestionar la clase IGestionarProveedorLocal
	 */
	@EJB
	private IGestionarProveedorLocal gestionarProveedorEJB;

	/**
	 * 
	 * Metodo encargado de traer la informacion de la lista de proveedores
	 * http://localhost:8085/semillero-servicios/rest/GestionarProveedor/consultarProveedores
	 * 
	 * @param idComic
	 * @return
	 */
	@GET
	@Path("/consultarProveedores")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProveedorDTO> consultarProveedor() throws NoExistenRegistrosException {
		// No se si la excepcion se debe capturar aca o en la capa de presentacion
		return gestionarProveedorEJB.consultarProveedores();
	}

	/**
	 * Crea los proveedores en sus diferentes roles dentro del sistema.
	 * http://localhost:8085/semillero-servicios/rest/GestionarProveedor/crearProveedor
	 * 
	 * @param proveedorDTO
	 * @throws NoExistenRegistrosException
	 * @throws MaximoProveedoresException
	 */
	@POST
	@Path("/crearProveedor")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void crearProveedor(ProveedorDTO proveedorDTO) throws NombreYaExisteException, NoExistenRegistrosException, MaximoProveedoresException {
		// No se si la excepcion se debe capturar aca o en la capa de presentacion
		gestionarProveedorEJB.crearProveedor(proveedorDTO);
	}

	/**
	 * Consulta el proveedor dentro del sistema.
	 * http://localhost:8085/semillero-servicios/rest/GestionarProveedor/consultarProveedorPorId
	 * 
	 * @param proveedorDTO
	 */
	@GET
	@Path("/consultarProveedorPorId")
	@Produces(MediaType.APPLICATION_JSON)
	public ProveedorDTO consultarProveedorPorId(String id) throws NoExistenRegistrosException {
		// No se si la excepcion se debe capturar aca o en la capa de presentacion
		return gestionarProveedorEJB.consultarProveedorPorId(id);
	}

	/**
	 * 
	 * Metodo encargado de modificar el nombre de un proveedor
	 * http://localhost:8085/semillero-servicios/rest/GestionarProveedor/modificarProveedorNombre
	 * 
	 * @param id     identificador del proveedor
	 * @param nombre nuevo del proveedor
	 */
	@POST
	@Path("/modificarProveedorNombre")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void modificarProveedorNombre(@QueryParam("idProveedor") String id, @QueryParam("nombre") String nombre)
			throws NoExistenRegistrosException {
		gestionarProveedorEJB.modificarNombre(id, nombre);
	}

	/**
	 * 
	 * Metodo encargado de modificar el monto del credito de un proveedor
	 * http://localhost:8085/semillero-servicios/rest/GestionarProveedor/modificarProveedorMontoCredito
	 * 
	 * @param id         identificador del proveedor
	 * @param montoNuevo del proveedor
	 */
	@POST
	@Path("/modificarProveedorMontoCredito")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void modificarProveedorMontoCredito(@QueryParam("idProveedor") String id,
			@QueryParam("nombre") BigDecimal montoNuevo) throws NoExistenRegistrosException {
		gestionarProveedorEJB.modificarMontoCredito(id, montoNuevo);
	}

	/**
	 * 
	 * Metodo encargado de eliminar un proveedor
	 * http://localhost:8085/semillero-servicios/rest/GestionarProveedor/eliminarProveedor
	 * 
	 * @param id identificador del proveedor
	 */
	@POST
	@Path("/eliminarProveedor")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void eliminarComic(@QueryParam("idProveedor") String id) throws NoExistenRegistrosException {
		gestionarProveedorEJB.eliminarProveedor(id);
	}

	/**
	 * 
	 * Metodo encargado dde notificar cuando el credito de un proveedor esta proximo
	 * a coparse
	 * http://localhost:8085/semillero-servicios/rest/GestionarProveedor/notificarCredito
	 * 
	 * @param idProveedor identificador del proveedor
	 * @throws NoExistenRegistrosException
	 */
	@Path("/notificarCredito")
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean notificarCreditoProximoCoparse(String idProveedor) throws NoExistenRegistrosException {
		return gestionarProveedorEJB.notificarCreditoProximoCoparse(idProveedor);
	}

	/**
	 * 
	 * Metodo encargado dde notificar cuando el contrato sigue vigente a coparse
	 * http://localhost:8085/semillero-servicios/rest/GestionarProveedor/notificarVigenciaContrato
	 * 
	 * @param idProveedor identificador del proveedor
	 * @throws NoExistenRegistrosException
	 */
	@Path("/notificarVigenciaContrato")
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean notificarVigenciaContrato(String idProveedor) throws NoExistenRegistrosException {
		return gestionarProveedorEJB.notificarVigenciaContrato(idProveedor);
	}

	/**
	 * 
	 * Metodo encargado dde notificar cuando el contrato sigue vigente a coparse
	 * http://localhost:8085/semillero-servicios/rest/GestionarProveedor/calcularCantidadProveedores
	 * 
	 * @param idProveedor identificador del proveedor
	 * @throws NoExistenRegistrosException
	 */
	@Path("/calcularCantidadProveedores")
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean calcularCantidadProveedores() throws NoExistenRegistrosException {
		return gestionarProveedorEJB.calcularCantidadProveedoresActivos();
	}

}// Cierre de la clase
