import { HttpClient,HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
//import { subscribe } from "diagnostics_channel";

@Injectable({
    providedIn: 'root'
})export class UsuariosServiceService{

    public listaUsuario: any[];
    public urlServidor: string = "http://localhost:8081/"
    public usuario: any;

    constructor(private postMan: HttpClient){
        this.listaUsuario= [];
        this.usuario= {};
    }

    //Métodos que realiza la petición get a la api//consume api local
    //para obtener la lista de clientes

    obtenerListaUsuarios():void{
        this.postMan.get(this.urlServidor+"apip4/usuarios").subscribe((respuesta:any)=>{
            console.log(respuesta);
            this.listaUsuario=respuesta;
        });
    }

    //Método que realiza una petición delete a la ap
    eliminarUsuario(id:number){
        const parametrosPeticion= new HttpParams().set("id",id)
        this.postMan.delete(this.urlServidor+"apip4/usuarios/eliminar", {params: parametrosPeticion}).subscribe((respuesta:any)=>{
            console.log(respuesta);
            this.obtenerListaUsuarios();
        });
    }

    //Método que realiza petición post a la api para insertar un nuevo cliente
    guardarUsuario(nombre:string, correo:string, contrasenia:string,fechaRegistro:Date, preferenciaViaje:string){

        this.postMan.post(this.urlServidor+"apip4/usuarios", {
            "nombre":nombre,
            "correo":correo,
            "contrasenia":contrasenia,
            "fechaRegistro": fechaRegistro,
            "preferenciaViaje": preferenciaViaje
        },).subscribe((respuesta:any)=>{
            console.log(respuesta.msg);
        });
    }

}