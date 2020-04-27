import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../../models/User';
import {Observable} from 'rxjs';

const API_URL = 'http://localhost:7788/api/test/';

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(private httpClient: HttpClient) {
  }

  getPublicContent(): Observable<any> {
    console.log('user service test 1 public content');
    return this.httpClient.get(API_URL + 'all', {responseType: 'text'});
  }

  getUserContent(): Observable<any> {
    console.log('user service test 2 user content');
    return this.httpClient.get(API_URL + 'user', {responseType: 'text'});
  }

  getAdminContent(): Observable<any> {
    console.log('user service test 3 admin content');
    return this.httpClient.get(API_URL + 'admin', {responseType: 'text'});
  }

  getUsers() {
    console.log('Getting all users');
    console.log('user service test 4 get users');
    return this.httpClient.get<User[]>('http://localhost:7788/api/test/getallusers');
    // return this.httpClient.get<User[]>(API_URL + 'getallusers');
    // return this.httpClient.get<User[]>('http://localhost:7788/api/test/all');
  }

  addUser(newUser: User) {
    console.log('user service test 5 add user');
    return this.httpClient.post<User>('http://localhost:7788/api/auth/signup', newUser);
  }

  deleteUser(id: number) {
    // @ts-ignore
    // return this.httpClient.delete<User>('http://localhost:7788/api/test/deleteuser/', id);
    console.log('user service test 6 delete user');
    return this.httpClient.post<User>(API_URL + 'testpost/', id);
  }
}
