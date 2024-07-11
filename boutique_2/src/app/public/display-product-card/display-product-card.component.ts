import { Component, OnInit, inject } from '@angular/core';
import { ProductService, Product } from '../../services/product.service'; 
import {  MatCardModule } from '@angular/material/card';
import { CommonModule } from '@angular/common';
import { HttpClient,HttpClientModule } from '@angular/common/http';


@Component({
  selector: 'app-display-product-card',
  standalone: true,
  imports: [MatCardModule,CommonModule,HttpClientModule],
  //templateUrl: './display-product-card.component.html',
  styleUrl: './display-product-card.component.scss',
  providers: [ProductService],

  template: `
  
    <div style=" color : white; display: inline-block; margin: 10px;" *ngFor="let obj of objects" >
	
      <mat-card [style.width.%]="45" [style.height.%]="35">
  
        <mat-card-header>
  
          <mat-card-title>{{ obj.name }}</mat-card-title>
  
          <mat-card-subtitle>{{ obj.quantity }}</mat-card-subtitle>
  
        </mat-card-header>
  
        <img matCardImage [src]="'https://images.alphacoders.com/115/thumbbig-1159914.webp'">
  
        <mat-card-content>
  
          {{ obj.description }}
  
        </mat-card-content>
  
      </mat-card>
	
  
    </div>
  
  `
})


export class DisplayProductCardComponent implements OnInit {
  private http = inject(HttpClient); ; // Inject HttpClient instance

  objects!: Product[];

  constructor(private produitServices: ProductService) {  
    
  }
 

 /* generateTemplate(): string {

    return `

      <div *ngFor="let obj of objects">

        <mat-card>

          <mat-card-header>

            <mat-card-title>{{ obj.name }}</mat-card-title>

            <mat-card-subtitle>{{ obj.quantity }}</mat-card-subtitle>

          </mat-card-header>

          <img matCardImage [src]="null">

          <mat-card-content>

            {{ obj.description }}

          </mat-card-content>

        </mat-card>

      </div>

    `;

  }*/
  ngOnInit() {this.produitServices.getAllProducts().subscribe((data) => {
    this.objects = data;
  });
   
  }
  onActionClick(){}
}
