import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UsuariosServiceService 
{
  public listaUsuarios: any[];
  public urlServidor: string = "http://localhost:8081/"
  public usuario : any;

  constructor(private postMan: HttpClient) 
  { 
    this.listaUsuarios = [];
    this.usuario = {};
  }

  obtenerListaUsuario():void
  {
    this.postMan.get(this.urlServidor + "apip4/usuarios").subscribe((respuesta: any)=>{
      console.log(respuesta);
      this.listaUsuarios = respuesta;
    });
  }

  eliminarUsuario(id:number)
  {
    const parametrosPeticion = new HttpParams().set("id", id)
    this.postMan.delete(this.urlServidor + "apip4/usuarios/eliminar", {params: parametrosPeticion}).subscribe((respuesta: any)=>{
      console.log(respuesta);
      this.obtenerListaUsuario();
    });

  }
}
