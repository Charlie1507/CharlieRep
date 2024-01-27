import { Routes } from '@angular/router';
import { ListadoUsuarioComponent } from './listado-usuario/listado-usuario.component';
import { AltaUsuarioComponent } from './alta-usuario/alta-usuario.component';
import { DetalleComponent } from './detalle/detalle.component';
import { EdicionComponent } from './edicion/edicion.component';

export const routes: Routes = [
    {path: "usuarios", component: ListadoUsuarioComponent},
    {path: "usuarios/alta", component: AltaUsuarioComponent},
    {path: "usuarios/detalle/:id", component: DetalleComponent},
    {path: "usuarios/editar/:id", component: EdicionComponent},
    {path:"", redirectTo : "/usuarios", pathMatch: "full"}
];
