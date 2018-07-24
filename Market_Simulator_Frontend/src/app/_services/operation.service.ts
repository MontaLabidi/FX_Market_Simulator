import { Injectable } from '@angular/core';
import { Operation } from '../_models';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OperationService {

  constructor(private http:HttpClient) { }

  private BaseUrl = '/api';

  public getById(id: number) {
    return this.http.get<Operation>(this.BaseUrl + '/operation=' + id);
  }
  public getAll() {

    return this.http.get<Operation[]>(this.BaseUrl +'/operations');
  }
  public getAllByUser(user_id: number) {

    return this.http.get<Operation[]>(this.BaseUrl +"/user="+user_id+'/operations');
  }

  public delete(id: number) {
    return this.http.delete(this.BaseUrl + "/operation="+id);
  }
  public deleteAllOperations() {
    return this.http.delete(this.BaseUrl + "/operations");
  }
  public create(user_id: number,currency_id: number,Operation) {
    return this.http.post<Operation>(
      this.BaseUrl+"/user="+user_id+"/currency="+currency_id+"/operation", Operation);
  }
  public update(Operation) {
    return this.http.put<Operation>(this.BaseUrl + '/currency', Operation);
  }

  }
