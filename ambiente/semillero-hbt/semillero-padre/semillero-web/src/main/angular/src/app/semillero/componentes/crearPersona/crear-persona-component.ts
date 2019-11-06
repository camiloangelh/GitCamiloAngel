import { Component, OnInit } from '@angular/core';
import { ObjetoSesionDos } from '../../dto/objetoSesionDos.dto';
import { isUndefined } from 'util';

/**
 * @description Componente crear persona, permite crear personas
 * 
 * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
 */
@Component({
    selector: 'crear-persona',
    templateUrl: './crear-persona-component.html'
})
export class CrearPersonaComponent implements OnInit {
    
    /**
     * Variable que representa el nombre de instructor global privado
     */
    private nombreInstructorGlobalPrivado : string;
     /**
     * Variable que representa el nombre de instructor global publico
     */
    public nombreInstructorGlobalPublico : string;

    /**
     * Variable que representa la lista de apelliedos
     */
    public listaApellidos : Array<any> = new Array<any>();

    /**
     * Variable que representa el mensaje de la lista
     */
    public mensajeLista : any;

    /**
     * Variable que representa la lista de objetos 
     */
    public listaObjetosSesionDos: Array<ObjetoSesionDos>;
    /**
     * Varible que representa el mensaje del boton eliminar
     */
    public mensajeBtnEliminar: string;
    /**
     * Variable que representa un centinela
     */
    public centinela: boolean;

    /**
     * Metodo que se ejecuta cuando se inicia el componente
     */
    ngOnInit(): void {

        //this.inicializarComponente();
        this.inicializarEjercicioSesionDos();
        let nombreInstructor = "Diego Alvarez";
        let nombreEstudiante : string = "Camilo Angel";
        console.log("Nombre instructor: " + nombreInstructor);
        console.log("Nombre estudiante: "+ nombreEstudiante);
 
        let miVariable : any = {
        id : 1,
        nombre : "Carlos",
        direccion : "Carrera 18 #800-90"
        };
        miVariable.genero = "masculino";

        let miNumero : number = 100.25;

        let miVariableBoolean : boolean = true;

        let miMapa : Map<string, string>;
        miMapa = new Map<string, string>();
        miMapa.set("1", "Semillero");

        let fecha = new Date();
        console.log(fecha);

        this.listaApellidos.push(miVariable);
        this.listaApellidos = [];
        //alert("La longitud de la lista apellidos es de: " + this.listaApellidos.length);
        //alert(`El nombre del instructor es: ${nombreInstructor} y el nombre del estudiante es: ${nombreEstudiante}`);
    
        for (let index = 0; index < this.listaApellidos.length; index++) {
            const element = this.listaApellidos[index];
            //console.log(element);
        }

        this.listaApellidos.forEach(element => {
            //console.log(element);
        });

        this.listaApellidos.map(objeto => {
            //console.log(objeto);
        });

    }

    /**
     * Metodo que inicializa la variables
     */
    public inicializarComponente() : Array<string> {
        let retorno : any;
        let objeto = undefined;
        if(objeto !== null && objeto !== undefined){
            console.log("No es nulo")
        } else {
            console.log("Si es nulo");
        }
 
        console.log(1 == 1);
        //console.log("1" == 1);
        console.log(1 === 1);
        //console.log("1" === 1);
        return retorno;
    }
   
    /**
     * Metodo para la realiazacion del ejercicio de la sesion 2 angular
     */
    public inicializarEjercicioSesionDos(): void {
        this.mensajeBtnEliminar = "";
        this.listaObjetosSesionDos = new Array<ObjetoSesionDos>();
        let objetoSesionDos: ObjetoSesionDos = new ObjetoSesionDos();
        //Instancia numero 1
        objetoSesionDos.id = 1;
        objetoSesionDos.nombre = "Batman";
        objetoSesionDos.editorial = "marvel";
        objetoSesionDos.tematica = "accion";
        objetoSesionDos.numeroPaginas = 50;
        objetoSesionDos.precio = 60,500.99;
        objetoSesionDos.autores = "Pedrito barrera";
        objetoSesionDos.aColor = true;
        objetoSesionDos.fechaVenta = new Date("10-10-2019");
        objetoSesionDos.estado = "activo";
        this.listaObjetosSesionDos.push(objetoSesionDos);
        //Instancia numero 2
        objetoSesionDos = new ObjetoSesionDos();
        objetoSesionDos.id = 2;
        objetoSesionDos.nombre = "Superman";
        objetoSesionDos.editorial = "marvel";
        objetoSesionDos.tematica = "accion";
        objetoSesionDos.numeroPaginas = 50;
        objetoSesionDos.precio = 60,500.99;
        objetoSesionDos.autores = "Pedrito barrera";
        objetoSesionDos.aColor = true;
        objetoSesionDos.fechaVenta = new Date("10-10-2018");
        objetoSesionDos.estado = "activo";
        this.listaObjetosSesionDos.push(objetoSesionDos);
        //Instancia numero 3
        objetoSesionDos = new ObjetoSesionDos();
        objetoSesionDos.id = 3;
        objetoSesionDos.nombre = "Aquaman";
        objetoSesionDos.editorial = "DC Comics";
        objetoSesionDos.tematica = "accion";
        objetoSesionDos.numeroPaginas = 50;
        objetoSesionDos.precio = 60,500.99;
        objetoSesionDos.autores = "Pedrito barrera";
        objetoSesionDos.aColor = true;
        objetoSesionDos.fechaVenta = new Date("10-10-2017");
        objetoSesionDos.estado = "activo";
        this.listaObjetosSesionDos.push(objetoSesionDos);
        //Instancia numero 4
        objetoSesionDos = new ObjetoSesionDos();
        objetoSesionDos.id = 4;
        objetoSesionDos.nombre = "Mujer Maravilla";
        objetoSesionDos.editorial = "DC Comics";
        objetoSesionDos.tematica = "accion";
        objetoSesionDos.numeroPaginas = 50;
        objetoSesionDos.precio = 60,500.99;
        objetoSesionDos.autores = "Pedrito barrera";
        objetoSesionDos.aColor = true;
        objetoSesionDos.fechaVenta = new Date("10-10-2018");
        objetoSesionDos.estado = "activo";
        this.listaObjetosSesionDos.push(objetoSesionDos);
        //Instancia numero 5
        objetoSesionDos = new ObjetoSesionDos();
        objetoSesionDos.id = 5;
        objetoSesionDos.nombre = "Flashpoint";
        objetoSesionDos.editorial = "DC Comics";
        objetoSesionDos.tematica = "accion";
        objetoSesionDos.numeroPaginas = 50;
        objetoSesionDos.precio = 60,500.99;
        objetoSesionDos.autores = "Pedrito barrera";
        objetoSesionDos.aColor = true;
        objetoSesionDos.fechaVenta = new Date("10-10-2015");
        objetoSesionDos.estado = "activo";
        this.listaObjetosSesionDos.push(objetoSesionDos);

        this.mensajeLista = JSON.stringify(this.listaObjetosSesionDos);
    }

    /**
     * Metodo para eliminar el objeto en la posicion 3 del array
     */
    public eliminarElementoListaObjeto(posicion : number) : void{
       
        if(this.listaObjetosSesionDos.length > posicion){ 
           
            this.mensajeBtnEliminar = "Se ha eliminado el comic" + this.listaObjetosSesionDos[posicion].nombre;
            this.listaObjetosSesionDos.splice(posicion, 1);
            this.centinela = true;    
        }else{
            this.mensajeBtnEliminar = "";
            this.centinela = false;
        }
    }

}//Cierre del componente