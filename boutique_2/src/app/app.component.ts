import { APP_BOOTSTRAP_LISTENER, Component } from '@angular/core';
import { bootstrapApplication } from '@angular/platform-browser';

import { RouterOutlet, Routes, provideRouter, RouterLink  } from '@angular/router';
import { ProductFormComponent } from './admin/product-form/product-form.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,RouterLink],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'boutique-front';
}
/*const routes: Routes = [
{ path: '', component: AppComponent }, // Default route for app component
{ path: 'product-form', component: ProductFormComponent }, // Route for product form
];
const bootstrapFn = () => {
  return provideRouter(routes);
};
// Bootstrap the application with the routes
// Bootstrap the application with the routes
//bootstrapApplication(AppComponent, { providers: [{ provide: APP_BOOTSTRAP_LISTENER, useFactory: bootstrapFn, multi: true }] });*/