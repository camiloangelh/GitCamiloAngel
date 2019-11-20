/**
 * @description Clase ProveedorDTO que contiene la informacion de un Proveedor
 * 
 * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
 */
export class ProveedorDTO {

    /**
     * Atributo que representa el identificador del proveedor
     */
    public id : string;

     /**
     * Atributo que representa el nombre del proveedor
     */
    public nombre: string;

     /**
     * Atributo que representa la direccion del proveedor
     */
    public direccion: string;

     /**
     * Atributo que representa la fechaCreacion del proveedor
     */
    public fechaCreacion: Date;

     /**
     * Atributo que representa el estado del proveedor
     */
    public estado : string;

     /**
     * Atributo que representa el montoCredito del proveedor
     */
    public montoCredito : number;

}