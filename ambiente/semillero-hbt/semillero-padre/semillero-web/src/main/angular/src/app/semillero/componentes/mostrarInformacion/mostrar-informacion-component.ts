import { OnInit, Component } from '@angular/core';

/**
 * @description componente que muestra mi informacion: nombre, ciudad y GitURL
 * 
 * @author Camilo Angel Hurtado <cangelh@uqvirtual.edu.co>
 */
@Component({
    selector: 'mostrar-informacion',
    templateUrl: './mostrar-informacion-component.html',
  })
  export class MostrarInformacionComponent implements OnInit{
    ngOnInit(): void {
        throw new Error("Method not implemented.");
      }
    
      /**
       * Constructor
       */
    constructor(){
      console.log()
    }
  }