import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Book} from '../../models/Book';
import {Reservation} from '../../models/Reservation';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private httpClient: HttpClient) { }

  getReservations() {
    return this.httpClient.get<Reservation[]>('http://localhost:9191/reserve/getall');
  }

  getReservationById(id: number) {
    return this.httpClient.get<Reservation[]>('http://localhost:9191/reserve/getbyid' + id);
  }

  getReservedUser(id: number) {
    return this.httpClient.get<Reservation[]>('http://localhost:9191/reserve/getbyuserid/' + id);
  }

  getReservedBook(id: number) {
    return this.httpClient.get<Reservation[]>('http://localhost:9191/reserve/getbybookid' + id);
  }

  addNewReservation(newRes: Reservation) {
    return this.httpClient.post<Book>('http://localhost:9191/reserve/save', newRes);
  }

}
