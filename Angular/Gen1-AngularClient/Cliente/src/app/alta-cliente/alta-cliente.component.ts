import { Component, ViewChild, ElementRef } from '@angular/core';
import { ClientesServiceService } from '../clientes-service.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-alta-cliente',
  standalone: true,
  imports: [],
  templateUrl: './alta-cliente.component.html',
  styleUrl: './alta-cliente.component.css'
})
export class AltaClienteComponent 
{
  //Atributos 

  @ViewChild("nombre")
  referenciaNombre!: ElementRef;

  @ViewChild("apPaterno")
  referenciaApPaterno!: ElementRef;

  @ViewChild("apMaterno")
  referenciaApMaterno!: ElementRef;

  @ViewChild("telefono")
  referenciaTelefono!: ElementRef;

  @ViewChild("correo")
  referenciaCorreo!: ElementRef;

  @ViewChild("numAfiliado")
  referenciaNumAfiliado!: ElementRef;

  constructor(private servicio: ClientesServiceService, private router: Router)
  {

  }

  guardarCliente()
  {
    //recuperar los valores
    const nombre = this.referenciaNombre.nativeElement.value;
    const apPaterno = this.referenciaApPaterno.nativeElement.value;
    const apMaterno = this.referenciaApMaterno.nativeElement.value;
    const telefono = this.referenciaTelefono.nativeElement.value;
    const correo = this.referenciaCorreo.nativeElement.value;
    const numAfiliado = this.referenciaNumAfiliado.nativeElement.value;

    this.servicio.guardarCliente(nombre, apPaterno, apMaterno, telefono, correo, numAfiliado);
    this.router.navigate(['clientes']);

    Swal.fire({
      position: "top-end",
      icon: "success",
      title: "Cliente guardado correctamente",
      showConfirmButton: false,
      timer: 1500
    });
  }

}
