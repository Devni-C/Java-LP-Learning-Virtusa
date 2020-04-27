import {Injectable} from '@angular/core';

const TOKEN_KEY = 'auth-token';
const USER_KEY = 'auth-user';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {
// to manages token and user information (username, email, roles)
// inside Browser’s Session Storage
// By clearing this session storage we can logout
  constructor() {
  }

  signOut() {
    console.log('token storage test 1 signout');
    window.sessionStorage.clear();
    console.log('token storage test 2 signout');
  }

  public saveToken(token: string) {
    console.log('token storage test 3 save token');
    window.sessionStorage.removeItem(TOKEN_KEY);
    console.log('token storage test 4 save token');
    window.sessionStorage.setItem(TOKEN_KEY, token);
    console.log('token storage test 5 save token');
  }

  public getToken(): string {
    console.log('token storage test 6 get token');
    return sessionStorage.getItem(TOKEN_KEY);
    console.log('token storage test 7 get token');
  }

  public saveUser(user) {
    console.log('token storage test 8 save user');
    window.sessionStorage.removeItem(USER_KEY);
    console.log('token storage test 9 save user');
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
    console.log('token storage test 10 save user');
  }

  public getUser() {
    console.log('token storage test 11 get user');
    return JSON.parse(sessionStorage.getItem(USER_KEY));
    console.log('token storage test 12 get user');
  }
}
