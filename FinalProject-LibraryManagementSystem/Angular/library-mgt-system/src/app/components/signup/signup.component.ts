import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../services/auth/auth.service';
import {findLast} from '@angular/compiler/src/directive_resolver';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
// import {ConfirmedValidator} from './confirmed.validator';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  form: any = {};
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private authService: AuthService) {
  }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.form.value);
    this.authService.register(this.form).subscribe(
      data => {
        console.log('data ' + data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }
}
