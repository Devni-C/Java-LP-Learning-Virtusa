import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

const AUTH_API = 'http:localhost:7788/api/auth/';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  // This service sends signup, login HTTP POST requests to back-end

  constructor(private httpClient: HttpClient) {
  }

  login(credentials): Observable<any> {
    return this.httpClient.post('http://localhost:7788/api/auth/signin', {
      username: credentials.username,
      password: credentials.password
    }, httpOptions);
  }

  register(user): Observable<any> {
    console.log('register test 1');
    console.log('register test 2' + ' ' + user.username + ' ' + user.email + ' ' + user.mobile + ' ' + user.password);
    // return this.httpClient.post(AUTH_API + 'signup', {
    return this.httpClient.post('http://localhost:7788/api/auth/signup', {
      username: user.username,
      email: user.email,
      password: user.password,
      name: user.name,
      mobile: user.mobile
    }, httpOptions);
    console.log('register test 3' + ' ' + user.username + ' ' + user.email + ' ' + user.mobile + ' ' + user.password);
  }
}
