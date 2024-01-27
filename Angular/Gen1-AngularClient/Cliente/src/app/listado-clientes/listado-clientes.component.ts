import { Component } from '@angular/core';
import { ClientesServiceService } from '../clientes-service.service';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listado-clientes',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './listado-clientes.component.html',
  styleUrl: './listado-clientes.component.css'
})
export class ListadoClientesComponent 
{
  /**
   *
   */
  constructor(public servicio: ClientesServiceService) 
  {
    this.servicio.obtenerListaClientes();
  }

  //get
  get listaClientes()
  {
    return this.servicio.listaClientes;
  }

  //metodos
  eliminar(id:number)
  {
    Swal.fire({
      title: "Are you sure?",
      text: "You won't be able to revert this!",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Yes, delete it!"
    }).then((result) => {
      if (result.isConfirmed) 
      {
        this.servicio.eliminarCliente(id);
        Swal.fire({
          title: "Deleted!",
          text: "Your file has been deleted.",
          icon: "success"
        });
      }
    });
    
  }

}
