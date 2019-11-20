package com.hbt.semillero.ejb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.entidades.EstadoProveedorEnum;
import com.hbt.semillero.entidades.Proveedor;
import com.hbt.semillero.excepciones.MaximoProveedoresException;
import com.hbt.semillero.excepciones.NoExistenRegistrosException;
import com.hbt.semillero.excepciones.NombreYaExisteException;

/**
 * Clase que permite gestionar los requerimientos de negocio referentes a la
 * clase Proveedor
 * 
 * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
 *
 */
@Stateless
public class GestionarProveedorBean implements IGestionarProveedorLocal {

	/**
	 * Variable que permite administrar la informacion de la entidad
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarProveedorLocal#crearProveedor(com.hbt.
	 * semillero.dto.ProveedorDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearProveedor(ProveedorDTO proveedorDTO) throws NombreYaExisteException, NoExistenRegistrosException, MaximoProveedoresException {
		// Se valida que el nombre del proveedor no exista
		if (consultarProveedorPorNombre(proveedorDTO.getNombre()) == null) {
			//Se valida que haya un maximo de 30 proveedores activos
			if(!calcularCantidadProveedoresActivos()) {
			Proveedor proveedor = convertirProveedorDTOToProveedor(proveedorDTO);
			// Se persiste el proveedor
			entityManager.persist(proveedor);
			}else {
				throw new MaximoProveedoresException("Maximo proveedores permitidos");
			}
		} else {
			throw new NombreYaExisteException();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarProveedorLocal#consultarProveedores()
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ProveedorDTO> consultarProveedores() throws NoExistenRegistrosException {
		List<ProveedorDTO> resultadoProveedorDTO = new ArrayList<ProveedorDTO>();
		List<Proveedor> resultadoProveedor = entityManager.createQuery("select p from Proveedor p").getResultList();
		// Se valida que la lista tenga proveedores almacenados
		if (resultadoProveedor.size() > 0) {
			for (Proveedor proveedor : resultadoProveedor) {
				resultadoProveedorDTO.add(convertirProveedorToProveedorDTO(proveedor));
			}
			return resultadoProveedorDTO;
		} else {
			throw new NoExistenRegistrosException("No hay registros de proveedor en la BD's");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hbt.semillero.ejb.IGestionarProveedorLocal#consultarProveedorPorId(java.
	 * lang.String)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ProveedorDTO consultarProveedorPorId(String id) throws NoExistenRegistrosException {
		Proveedor proveedor = entityManager.find(Proveedor.class, Long.parseLong(id));
		if (proveedor != null) {
			return convertirProveedorToProveedorDTO(proveedor);
		} else {
			throw new NoExistenRegistrosException("No existe el proveedor con id = " + id);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hbt.semillero.ejb.IGestionarProveedorLocal#consultarProveedorPorNombre(
	 * java.lang.String)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ProveedorDTO consultarProveedorPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hbt.semillero.ejb.IGestionarProveedorLocal#modificarNombre(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarNombre(String id, String nombreNuevo) throws NoExistenRegistrosException {
		ProveedorDTO proveedorDTO = consultarProveedorPorId(id);
		proveedorDTO.setNombre(nombreNuevo);
		Proveedor proveedorModificado = convertirProveedorDTOToProveedor(proveedorDTO);
		entityManager.merge(proveedorModificado);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hbt.semillero.ejb.IGestionarProveedorLocal#modificarMontoCredito(java.
	 * lang.String, java.math.BigDecimal)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarMontoCredito(String id, BigDecimal montoNuevo) throws NoExistenRegistrosException {
		ProveedorDTO proveedorDTO = consultarProveedorPorId(id);
		proveedorDTO.setMontoCredito(montoNuevo);
		Proveedor proveedorModificado = convertirProveedorDTOToProveedor(proveedorDTO);
		entityManager.merge(proveedorModificado);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hbt.semillero.ejb.IGestionarProveedorLocal#eliminarProveedor(java.lang.
	 * String)
	 */
	@Override
	public void eliminarProveedor(String id) throws NoExistenRegistrosException {
		ProveedorDTO proveedorDTO = consultarProveedorPorId(id);
		// Por reglas de negocio no se puede eliminar el proveedor, asi que se cambia el
		// estado a inactivo
		proveedorDTO.setEstadoProveedorEnum(EstadoProveedorEnum.INACTIVO);
		Proveedor proveedorModificado = convertirProveedorDTOToProveedor(proveedorDTO);
		entityManager.merge(proveedorModificado);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hbt.semillero.ejb.IGestionarProveedorLocal#notificarCreditoProximoCoparse
	 * (java.lang.String)
	 */
	public Boolean notificarCreditoProximoCoparse(String idProveedor) throws NoExistenRegistrosException {
		ProveedorDTO proveedorDTO = consultarProveedorPorId(idProveedor);

		if (proveedorDTO.getMontoCredito().equals(new BigDecimal("15000000"))) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hbt.semillero.ejb.IGestionarProveedorLocal#notificarVigenciaContrato(java
	 * .lang.String)
	 */
	public Boolean notificarVigenciaContrato(String idProveedor) throws NoExistenRegistrosException {
		ProveedorDTO proveedorDTO = consultarProveedorPorId(idProveedor);

		if (proveedorDTO.getEstadoProveedorEnum().equals(EstadoProveedorEnum.ACTIVO)) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hbt.semillero.ejb.IGestionarProveedorLocal#calcularCantidadProveedores()
	 */
	public Boolean calcularCantidadProveedoresActivos() throws NoExistenRegistrosException {
		Integer proveedoresActivos = 0;
		List<ProveedorDTO> proveedorDTOs = consultarProveedores();
		for (ProveedorDTO proveedorDTO : proveedorDTOs) {
			if (proveedorDTO.getEstadoProveedorEnum().equals(EstadoProveedorEnum.ACTIVO)) {
				proveedoresActivos++;
			}
		}
		if (proveedoresActivos == 30) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo encargado de convertir un proveedor a proveedorDTO
	 * 
	 * @param proveedor a convertir
	 */
	private ProveedorDTO convertirProveedorToProveedorDTO(Proveedor proveedor) {
		ProveedorDTO proveedorDTO = new ProveedorDTO();
		if (proveedor != null) {
			proveedorDTO.setId(proveedor.getId());
			proveedorDTO.setNombre(proveedor.getNombre());
			proveedorDTO.setDireccion(proveedor.getDireccion());
			proveedorDTO.setFechaCreacion(proveedor.getFechaCreacion());
			proveedorDTO.setMontoCredito(proveedor.getMontoCredito());
		}
		return proveedorDTO;
	}

	/**
	 * Metodo encargado de convertir un proveedorDTO a proveedor
	 * 
	 * @param proveedorDTO a convertir
	 */
	private Proveedor convertirProveedorDTOToProveedor(ProveedorDTO proveedorDTO) {
		Proveedor proveedor = new Proveedor();
		if (proveedorDTO != null) {
			proveedor.setId(proveedorDTO.getId());
			proveedor.setNombre(proveedorDTO.getNombre());
			proveedor.setDireccion(proveedorDTO.getDireccion());
			proveedor.setFechaCreacion(proveedorDTO.getFechaCreacion());
			proveedor.setMontoCredito(proveedorDTO.getMontoCredito());
		}
		return proveedor;
	}

}// Cierre de la clase
