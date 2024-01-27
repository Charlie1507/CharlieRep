import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ListadoUsuarioComponent } from './listado-usuario/listado-usuario.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { FooterComponent } from './footer/footer.component';
import { AltaUsuarioComponent } from './alta-usuario/alta-usuario.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ListadoUsuarioComponent, NavBarComponent, FooterComponent, AltaUsuarioComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Usuario';
}
