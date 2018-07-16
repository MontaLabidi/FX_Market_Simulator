import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from '../../environments/environment';
import { User } from '../_models';

@Injectable()
export class UserService {

  constructor(private http:HttpClient) {  }

  //private userUrl = 'http://localhost:8080/user-portal/user';
  private userUrl = '/api';

  public getById(id: number) {
    return this.http.get<User>(this.userUrl + '/' + id);
  }
  public getAll() {

    return this.http.get<User[]>('/api');
  }

  public delete(id: number) {
    return this.http.delete(this.userUrl + "/"+id);
  }
  public deleteAllUsers() {
    return this.http.delete(this.userUrl + "/");
  }
  public register(user) {
    return this.http.post<User>(this.userUrl+"/", user);
  }
  public update(user: User) {
    return this.http.put(this.userUrl + '/' + user.id, user);
  }

}
// export class UserService {
//
//     constructor(private http: HttpClient) { }
//
//     getAll() {
//         return this.http.get<User[]>(`${environment.apiUrl}/users`);
//     }
//
//     getById(id: number) {
//         return this.http.get(`${environment.apiUrl}/users/` + id);
//     }
//
//     register(user: User) {
//         return this.http.post(`${environment.apiUrl}/users/register`, user);
//     }
//
//     update(user: User) {
//         return this.http.put(`${environment.apiUrl}/users/` + user.id, user);
//     }
//
//     delete(id: number) {
//         return this.http.delete(`${environment.apiUrl}/users/` + id);
//     }
// }
