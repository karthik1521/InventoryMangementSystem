import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-update-customer',
  standalone: true,
  imports: [FormsModule,ReactiveFormsModule],
  templateUrl: './update-customer.component.html',
  styleUrl: './update-customer.component.css'
})
export class UpdateCustomerComponent {
  constructor(private activateRoute:ActivatedRoute,private router:Router,
    private cusServive:CustomerService, private fb:FormBuilder  ){

  }
  getCustomerForm!:FormGroup
  id: number=this.activateRoute.snapshot.params['id'];
  ngOnInit()
  {
    this.getCustomerForm=this.fb.group({
    pname:[null,Validators.required],
    pquantity:[null,Validators.required],
    price:[null,Validators.required],
    category:[null,Validators.required],
    supplier:[null,Validators.required],
    Dateofpacking:[null,Validators.required]
     })
     this.getCustomerById()
  }
  getCustomerById()
  {
    this.cusServive.getSingleCustomer(this.id).subscribe((res)=>{
      console.log(res);
      this.getCustomerForm.patchValue(res)
    })
  }
  updateCustomer(){
    this.cusServive.updateSingleCustomer(this.id,this.getCustomerForm.value).subscribe((res=>{
      console.log(res);
      this.router.navigateByUrl("");
    }))
  }
}
