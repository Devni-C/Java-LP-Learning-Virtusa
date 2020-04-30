import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {LoginComponent} from './components/login/login.component';
import {SignupComponent} from './components/signup/signup.component';
import {BooksComponent} from './components/admin/books/books.component';
import {UsersComponent} from './components/admin/users/users.component';
import {ViewBooksComponent} from './components/admin/books/view-books/view-books.component';
import {AddBookComponent} from './components/admin/books/add-book/add-book.component';
import {ProfileComponent} from './components/profile/profile.component';
import {ReservationComponent} from './components/reservation/reservation.component';


const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'signup', component: SignupComponent},
  {path: 'books', component: BooksComponent},
  {path: 'users', component: UsersComponent},
  {path: 'view-books', component: ViewBooksComponent},
  {path: 'add-books', component: AddBookComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'reserve', component: ReservationComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
