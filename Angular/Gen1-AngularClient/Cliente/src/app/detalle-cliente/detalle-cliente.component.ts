import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ClientesServiceService } from '../clientes-service.service';

@Component({
  selector: 'app-detalle-cliente',
  standalone: true,
  imports: [],
  templateUrl: './detalle-cliente.component.html',
  styleUrl: './detalle-cliente.component.css'
})
export class DetalleClienteComponent 
{
  //atributos
  private params :any;
  private id : number = 0;

  /**
   *
   */
  constructor(private ruta: ActivatedRoute, private servicio : ClientesServiceService) 
  {
    this.params = this.ruta.params.subscribe(parametros => {
      this.id = parametros["id"];
      console.log(this.id);
      this.servicio.obtenerCliente(this.id);
    })
    
  }

  get cliente()
  {
    return this.servicio.cliente;
  }
}
