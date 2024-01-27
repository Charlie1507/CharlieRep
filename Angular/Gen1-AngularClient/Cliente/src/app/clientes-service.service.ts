import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ClientesServiceService
{

  public listaClientes: any [];
  public urlServidor: string = "http://localhost:8081/"
  public cliente: any;


  constructor(private postMan: HttpClient) 
  { 
    this.listaClientes = [];
    this.cliente = {};
  }

  //metodos
  //metodo que realiza una peticion get a la api // consume tu api
  //para obtener la lista de clientes
  obtenerListaClientes():void
  {
    this.postMan.get(this.urlServidor + "api/clientes").subscribe((respuesta: any)=>{
      console.log(respuesta);
      this.listaClientes = respuesta;
    });
  }

  //metodo que realiza una peticion delete a la api

  eliminarCliente(id:number)
  {
    const parametrosPeticion = new HttpParams().set("id", id)
    this.postMan.delete(this.urlServidor + "api/clientes/eliminar", {params: parametrosPeticion}).subscribe((respuesta: any)=>{
      console.log(respuesta);
      this.obtenerListaClientes();
    });

  }

  //metoddo que realiza una peticion post a la api para insertar un nuevo cliente
  guardarCliente(nombre:string, apPat: string, apMat:string, telefono:string, correo: string, numAfiliado: string)
  {
    this.postMan.post(this.urlServidor + "api/clientes", {
    "nombre": nombre,
    "apPaterno":apPat,
    "apMaterno":apMat,
    "telefono":telefono,
    "correo":correo,
    "numAfiliado":numAfiliado
    },).subscribe((respuesta:any)=> {
      console.log(respuesta.msg);
    });
  }

  //funcion para realizar peticion get a la api para recuperar un cliente por id
  obtenerCliente(id:number):void
  {
    this.postMan.get(this.urlServidor + "api/clientes/obtener/" + id).subscribe((respuesta:any)=> {
      console.log(respuesta);
      this.cliente = respuesta;
    });

  }

  actualizarCliente(id:number, nombre:string, apPat: string, apMat:string, telefono:string, correo: string, numAfiliado: string)
  {
    this.postMan.put(this.urlServidor + "api/clientes/actualizar/" + id, {
    "id": id,
    "nombre": nombre,
    "apPaterno":apPat,
    "apMaterno":apMat,
    "telefono":telefono,
    "correo":correo,
    "numAfiliado":numAfiliado
    },).subscribe((respuesta:any)=> {
      console.log(respuesta.msg);
    });
  }

}
