import { Routes } from '@angular/router';
import { ListadoClientesComponent } from './listado-clientes/listado-clientes.component';
import { AltaClienteComponent } from './alta-cliente/alta-cliente.component';
import { DetalleClienteComponent } from './detalle-cliente/detalle-cliente.component';
import { EdicionClienteComponent } from './edicion-cliente/edicion-cliente.component';

export const routes: Routes = [
    {path: "clientes", component: ListadoClientesComponent},
    {path:"clientes/alta", component: AltaClienteComponent},
    {path:"clientes/detalle/:id", component: DetalleClienteComponent},
    {path:"clientes/editar/:id", component: EdicionClienteComponent},
    {path: "", redirectTo: "/clientes", pathMatch:"full"}
];
