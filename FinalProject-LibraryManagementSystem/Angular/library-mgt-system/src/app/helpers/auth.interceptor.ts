import {Injectable} from '@angular/core';
import {HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {TokenStorageService} from '../services/tokenStorage/token-storage.service';
import { HTTP_INTERCEPTORS } from '@angular/common/http';

const TOKEN_HEADER_KEY = 'Authorization';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private token: TokenStorageService) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    console.log('intercept test 1');
    let authReq = req;
    console.log('intercept test 2');
    const token = this.token.getToken();
    console.log('intercept test 3');
    if (token != null) {
      console.log('intercept test 4');
      authReq = req.clone({headers: req.headers.set(TOKEN_HEADER_KEY, 'Bearer ' + token)});
      console.log('intercept test 5');
    }
    return next.handle(authReq);
  }
}

export const authInterceptorProviders = [
  {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
];
