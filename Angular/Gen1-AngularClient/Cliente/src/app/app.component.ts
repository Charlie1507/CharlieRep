import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ListadoClientesComponent } from './listado-clientes/listado-clientes.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { FooterComponent } from './footer/footer.component';
import { AltaClienteComponent } from './alta-cliente/alta-cliente.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ListadoClientesComponent, NavBarComponent, FooterComponent, AltaClienteComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Cliente';
}
