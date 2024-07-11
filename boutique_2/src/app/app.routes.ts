import { Routes } from '@angular/router';
import { ProductFormComponent } from './admin/product-form/product-form.component';
import { DisplayProductCardComponent } from './public/display-product-card/display-product-card.component';

export const routes: Routes = [
    { path: 'product-form',
      component: ProductFormComponent 
    }, // Route for product form
    { path: 'display-product-card',
      component: DisplayProductCardComponent 
    }, 
];
