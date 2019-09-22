import { Injectable } from '@angular/core';
import { Observable, Observer } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private appUrl = 'http://localhost:8080/api/users';

  constructor(private http:HttpClient) { }

  getUser(userId:number):Observable<any>{
    return this.http.get(`${this.appUrl}/${userId}`);
  }

  createUser(user:Object):Observable<Object>{
    return this.http.post(`${this.appUrl}`,user);
  }
  
  updateUser(userId:number, value:any):Observable<Object>{
    return this.http.put(`${this.appUrl}/${userId}`,value);
  }

  deleteUser(userId: number): Observable<any>{
    return this.http.delete(`${this.appUrl}/${userId}`);
  }

  getUserList():Observable<any>{
    return this.http.get(`${this.appUrl}`);
  }

}
