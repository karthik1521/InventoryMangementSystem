import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
const BASIC_PATH=["http://localhost:8084"]

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  constructor( private http: HttpClient) { }

  CreateCustomer(products:any): Observable<any>
  {
    return this.http.post(BASIC_PATH+"/Products/createN",products)
  }
  getAllCustomer(): Observable<any>
  {
    return this.http.get(BASIC_PATH+"/Products/getall");
  }

  delCustomer(id:any):Observable<any>
  {
    return this.http.delete(BASIC_PATH+"/Products/delt/"+id);
  }
  getSingleCustomer(id:any):Observable<any>
  {
    return this.http.get(BASIC_PATH+"/Products/"+id);
  }
  updateSingleCustomer(id:any,products:any):Observable<any>
  {
    return this.http.put(BASIC_PATH+"/Products/updateprod/"+id,products);
  }
}
