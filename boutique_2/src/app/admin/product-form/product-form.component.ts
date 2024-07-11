import { Component, OnInit, inject } from '@angular/core';
import { ReactiveFormsModule, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { HttpClient, HttpClientModule, HttpErrorResponse } from '@angular/common/http';
import { ProductService, Product } from '../../services/product.service'; // Assuming correct path
import { catchError, tap, throwError } from 'rxjs';
import { MatButtonModule } from '@angular/material/button';


@Component({
  selector: 'app-product-form',
  standalone: true, // Use standalone for Angular v14+
  imports: [ReactiveFormsModule, HttpClientModule,MatButtonModule], // Import HttpClientModule
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css'],
  providers: [ProductService]
})
export class ProductFormComponent implements OnInit {
  private http = inject(HttpClient); // Inject HttpClient instance

  productForm!: FormGroup;

  constructor(private fb: FormBuilder, private produitServices: ProductService) { }

  ngOnInit() {
    this.productForm = this.fb.group({
      name: ['', Validators.required],
      productDescription: ['', Validators.required],
      quantity: [0, Validators.required],
      price: [0, Validators.required]
    });
  }

  onSubmit() {
    if (this.productForm.valid) {
      const newProduct: Product = {
        name: this.productForm.value.name,
        description: this.productForm.value.productDescription,
        quantity: this.productForm.value.quantity,
        cost: this.productForm.value.price,
        // Add other product properties as needed
      }; // Get form data directly
  
      this.produitServices.createProduit(newProduct)
       .pipe(
          tap((response: Product) => {
          next:  console.log(response);
          }),
          catchError((error: HttpErrorResponse) => {
            console.error('Error creating product:', error);
            return throwError(error);
          })
        ).subscribe();
    } else {
      console.error('Product form is invalid:', this.productForm.errors);
      // Optionally display validation error messages to the user
    }
  }}