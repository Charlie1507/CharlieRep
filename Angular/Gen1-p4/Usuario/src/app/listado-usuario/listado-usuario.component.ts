import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { UsuariosServiceService } from '../usuarios-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listado-usuario',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './listado-usuario.component.html',
  styleUrl: './listado-usuario.component.css'
})
export class ListadoUsuarioComponent 
{
  constructor(public servicio: UsuariosServiceService) 
  {
    this.servicio.obtenerListaUsuario();
  }

  //get
  get listaClientes()
  {
    return this.servicio.listaUsuarios;
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
        this.servicio.eliminarUsuario(id);
        Swal.fire({
          title: "Deleted!",
          text: "Your file has been deleted.",
          icon: "success"
        });
      }
    });
    
  }

}
