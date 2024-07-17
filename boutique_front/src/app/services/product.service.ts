import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, catchError, tap, throwError } from 'rxjs';

export interface Product {
  
  name: string;
  description: string;
  cost: number;
  quantity: number;
  // Add other product properties as needed
}

@Injectable({
  providedIn: 'root' // Provide the service at the root level
})
export class ProductService {
  private apiUrl = 'http://localhost:8080/api' // Replace with your actual API URL

  constructor(private http: HttpClient) { }

  createProduit(produit: Product): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    })
    console.log("post prod");
  
    return this.http.post<Product>(`${this.apiUrl}/product`, produit, { headers })
     
  }
  
  getAllProducts(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
	  'Access-Control-Allow-Origin': '*'
    })
    console.log("get all prod");
  
    return this.http.get<Product[]>(`${this.apiUrl}/products`, { headers })
     
  }};