import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HomeComponent} from './components/home/home.component';
import {LoginComponent} from './components/login/login.component';
import {SignupComponent} from './components/signup/signup.component';
import {BooksComponent} from './components/admin/books/books.component';
import {UsersComponent} from './components/admin/users/users.component';
import {NavbarComponent} from './components/navbar/navbar.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {AddUserComponent} from './components/admin/users/add-user/add-user.component';
import {ViewUsersComponent} from './components/admin/users/view-users/view-users.component';
import {AddBookComponent} from './components/admin/books/add-book/add-book.component';
import {ViewBooksComponent} from './components/admin/books/view-books/view-books.component';
import {FooterComponent} from './components/footer/footer.component';
import { ProfileComponent } from './components/profile/profile.component';
import { ReservationComponent } from './components/reservation/reservation.component';
import { LendingComponent } from './components/lending/lending.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    SignupComponent,
    BooksComponent,
    UsersComponent,
    NavbarComponent,
    AddUserComponent,
    ViewUsersComponent,
    AddBookComponent,
    ViewBooksComponent,
    FooterComponent,
    ProfileComponent,
    ReservationComponent,
    LendingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
