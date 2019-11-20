import { OnInit, Component } from '@angular/core';
import { ProveedorDTO } from '../../dto/proveedor.dto';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { GestionarProveedorService } from '../../services/gestionar.proveedor.service';
import { Router } from '@angular/router';

/**
 * @description Componente encargado de gestionar el CRUD de un Proveedor
 * 
 * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
 */
@Component({
    selector: 'gestionar-proveedor',
    templateUrl: './gestionar-proveedor.html'
})
export class GestionarProveedorComponent implements OnInit {

    /**
    * Atributo que contiene los controles del formulario
    */
    public gestionarProveedorForm: FormGroup;

    /**
    * Atributo que contendra la informacion del comic
    */
    public proveedorDTO: ProveedorDTO;

    /**
    * Atributo que indica si se envio a validar el formulario
    */
    public submitted: boolean;

    /**
     * Atributo que contiene la lista de proveedores y su informacions
     */
    public listaProveedores: Array<ProveedorDTO>;

    /**
    * @description Este es el constructor del componente GestionarProveedorComponent
    * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
    */
    constructor(private fb: FormBuilder, private gestionarProveedorService: GestionarProveedorService,
        private router: Router) {
        this.gestionarProveedorForm = this.fb.group({
            nombreProveedor: [null, Validators.required],
            direccion: [null],
            montoCredito: [null],
            estado: [null]
        });
    }

    /**
    * @description Evento angular que se ejecuta al invocar el componente
    * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
    */
    ngOnInit(): void {
        this.proveedorDTO = new ProveedorDTO();
        this.listaProveedores = new Array<ProveedorDTO>();
        this.consultarProveedores();
    }

    /**
     * @description Metodo encargado de consultar los Proveedores existentes
     * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
     */
    public consultarProveedores(): void {
        this.gestionarProveedorService.consultarProveedores().subscribe(listaProveedores => {
            this.listaProveedores = listaProveedores;
        }, error => {
            console.log(error);
        });
    }

    /**
     * @description Metodo que permite crear un proveedor
     * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
     */
    public crearProveedor(): void {
        this.submitted = true;
        if (this.gestionarProveedorForm.invalid) {
            return;
        }
        this.proveedorDTO = new ProveedorDTO();
        this.proveedorDTO.nombre = this.gestionarProveedorForm.controls.nombreProveedor.value;
        this.proveedorDTO.direccion = this.gestionarProveedorForm.controls.direccion.value;
        this.proveedorDTO.montoCredito = this.gestionarProveedorForm.controls.montoCredito.value;
        this.proveedorDTO.estado = this.gestionarProveedorForm.controls.estado.value;

        this.gestionarProveedorService.crearProveedor(this.proveedorDTO).subscribe(error => {
            console.log(error);
        })
    }

    /**
     * @description Metodo que permite eliminar un proveedor de la lista de proveedores
     * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
     * @param idProveedor 
     */
    public eliminarProveedor(idProveedor: string): void {
        this.gestionarProveedorService.eliminarProveedor(idProveedor).subscribe(error => {
            console.log(error);
        })
    }

    /**
    * @description Metodo encargado de direccionar al componente ConsultarProveedorComponent
    * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
    */
    public navegarConsultarProveedor() {
        this.router.navigate(['consultar-proveedor']);
    }

}//Cierre del componente