import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { GestionarProveedorService } from '../../services/gestionar.proveedor.service';
import { Router, ActivatedRoute } from '@angular/router';

/**
 * @description Componente ConsultarComic, el cual define la consulta de un Comic
 * 
 * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
 */
@Component({
    selector: 'consultar-proveedor',
    templateUrl: './consultar-proveedor.html'
})
export class ConsultarProveedorComponent implements OnInit {

    /**
    * Atributo que contiene los controles del formulario
    */
    public consultarProveedorForm: FormGroup;

    /**
    * @description Este es el constructor del componente GestionarProveedorComponent
    * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
    */
    constructor(private fb: FormBuilder, private gestionarProveedorService: GestionarProveedorService,
        private router: Router, private activatedRoute: ActivatedRoute) {
        this.consultarProveedorForm = this.fb.group({
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
        let data = this.activatedRoute.snapshot.params;
        this.llenarCampos(data);
    }

    /**
    * @description Metodo que llena los campos del comic consultado
    * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
    */
    public llenarCampos(datosProveedor: any): void {
        this.consultarProveedorForm.controls.nombreProveedor.setValue(datosProveedor.nombre);
        this.consultarProveedorForm.controls.direccion.setValue(datosProveedor.direccion);
        this.consultarProveedorForm.controls.montoCredito.setValue(datosProveedor.montoCredito);
        this.consultarProveedorForm.controls.estadoProveedor.setValue(datosProveedor.estadoProveedor);

        //Se inhabilitan los campos de texto, debido a la consulta
        this.consultarProveedorForm.controls.nombreProveedor.disable();
        this.consultarProveedorForm.controls.direccion.disable();
        this.consultarProveedorForm.controls.montoCredito.disable();
        this.consultarProveedorForm.controls.estadoProveedor.disable();
    }

    /**
     * @description Metodo encargado de direccionar al componente GestionarProveedorComponent
     * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
     */
    public navegarGestionarProveedor(): void {
        this.router.navigate(['gestionar-proveedor']);
    }

    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
     */
    get f() {
        return this.consultarProveedorForm.controls;
    }

}