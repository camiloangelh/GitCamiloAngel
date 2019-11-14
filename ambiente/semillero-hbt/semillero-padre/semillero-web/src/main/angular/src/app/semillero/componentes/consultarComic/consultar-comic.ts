import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { ComicDTO } from '../../dto/comic.dto';

/**
 * @description Componente ConsultarComic, el cual define la consulta de un Comic
 * 
 * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
 */
@Component({
    selector: 'consultar-comic',
    templateUrl: './consultar-comic.html'
})
export class ConsultarComicComponent implements OnInit {

    /**
    * Atributo que contiene los controles del formulario
    */
    public consultarComicForm: FormGroup;

    /**
     * Atributo que contiene los datos del comic consultado
     */
    private comicDTO: ComicDTO;

    /**
 * @description Este es el constructor del componente ConsultarComicComponent
 * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
 */
    constructor(private fb: FormBuilder,
        private router: Router, private activatedRoute: ActivatedRoute) {
        this.consultarComicForm = this.fb.group({
            nombre: [null, Validators.required],
            editorial: [null],
            tematica: [null],
            coleccion: [null],
            numeroPaginas: [null],
            precio: [null],
            autores: [null],
            color: [null]
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
    public llenarCampos(datosComic: any): void {
        this.consultarComicForm.controls.nombre.setValue(datosComic.nombre);
        this.consultarComicForm.controls.editorial.setValue(datosComic.editorial);
        this.consultarComicForm.controls.tematica.setValue(datosComic.tematica);
        this.consultarComicForm.controls.coleccion.setValue(datosComic.coleccion);
        this.consultarComicForm.controls.numeroPaginas.setValue(datosComic.numeroPaginas);
        this.consultarComicForm.controls.precio.setValue(datosComic.precio);
        this.consultarComicForm.controls.autores.setValue(datosComic.autores);
        this.consultarComicForm.controls.color.setValue(datosComic.color);
        //Se inhabilitan los campos de texto, debido a la consulta
        this.consultarComicForm.controls.nombre.disable();
        this.consultarComicForm.controls.editorial.disable();
        this.consultarComicForm.controls.tematica.disable();
        this.consultarComicForm.controls.coleccion.disable();
        this.consultarComicForm.controls.numeroPaginas.disable();
        this.consultarComicForm.controls.precio.disable();
        this.consultarComicForm.controls.autores.disable();
        this.consultarComicForm.controls.color.disable();
    }

    /**
     * @description Metodo encargado de direccionar al componente GestionarComicComponent
     * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
     */
    public navegarGestionarComic(): void {
        this.router.navigate(['gestionar-comic']);
    }


    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
     */
    get f() {
        return this.consultarComicForm.controls;
    }

}//Cierre de la clase