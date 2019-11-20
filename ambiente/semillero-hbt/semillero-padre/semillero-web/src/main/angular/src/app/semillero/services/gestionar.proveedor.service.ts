import { Injectable } from '@angular/core';
import { Injector } from "@angular/core";
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { AbstractService } from './template.service'
import { HttpClient } from '@angular/common/http';
import { ProveedorDTO } from '../dto/proveedor.dto';

/**
 * @description Servicio encargado de llamar a los servicios REST de gestionar proveedor
 * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
 */
@Injectable({
  providedIn: 'root'
})
export class GestionarProveedorService extends AbstractService {

  /**
  * Constructor de la clase
  */
  constructor(injector: Injector, private httpClient: HttpClient) {
    super(injector);
  }

  /**
  * @description Metodo encargado de invocar el servicio REST consultar proveedores
  * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
  */
  public consultarProveedores(): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarProveedor/consultarProveedores');
  }

  /**
  * @description Metodo encargado de invocar el servicio REST crear proveedor
  * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
  * @param proveedorDTO proveedor al cual se crear en un registro
  */
  public crearProveedor(proveedorDTO: ProveedorDTO): Observable<any> {
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarProveedor/crearProveedor', proveedorDTO);
  }

  /**
   * @description Metodo encargado de invocar el servicio REST eliminar proveedor
   * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
   * @param idProveedor 
   */
  public eliminarProveedor(idProveedor: string){
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarProveedor/eliminarProveedor', idProveedor);
  }
  
}