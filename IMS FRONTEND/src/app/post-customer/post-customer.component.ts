import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { CustomerService } from '../customer.service';
import { provideHttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-post-customer',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './post-customer.component.html',
  styleUrl: './post-customer.component.css'
})
export class PostCustomerComponent {
  postCustomer!: FormGroup;
  constructor(private cusSer:CustomerService,private router:Router,private fb:FormBuilder){

  }
  ngOnInit()
  {
   this.postCustomer=this.fb.group({
    pname:[null,Validators.required],
    pquantity:[null,Validators.required],
    price:[null,Validators.required],
    category:[null,Validators.required],
    supplier:[null,Validators.required],
    Dateofpacking:[null,Validators.required]
   })
  }

  onCreate()
  {
    //console.log(this.postCustomer.value);
    this.cusSer.CreateCustomer(this.postCustomer.value).subscribe((res)=>
    {
      console.log(res);
      this.router.navigateByUrl("");
    })
  }
}
