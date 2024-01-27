import { Component } from '@angular/core';
import { UsuariosServiceService } from '../usuarios-service.service';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-listado-usuarios',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './listado-usuarios.component.html',
  styleUrl: './listado-usuarios.component.css'
})
export class ListadoUsuariosComponent {

  constructor(public servicio: UsuariosServiceService){
    this.servicio.obtenerListaUsuarios();
  }


  //get
  get listaUsuarios(){
    return this.servicio.listaUsuario;
  }


  //Aquí quedamos 24012024
  //Método
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
      if (result.isConfirmed) {
        Swal.fire({
          title: "Deleted!",
          text: "Your file has been deleted.",
          icon: "success"
        });
      }
    });
  }
}
