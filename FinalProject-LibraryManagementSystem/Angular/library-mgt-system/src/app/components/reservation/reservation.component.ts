import {Component, OnInit} from '@angular/core';
import {User} from '../../models/User';
import {Reservation} from '../../models/Reservation';
import {HttpClientService} from '../../services/user/http-client.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ReservationService} from '../../services/reservation/reservation.service';
import {Book} from '../../models/Book';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {
  reserve: Array<Reservation>;
  ress: Array<Reservation>;

  constructor(private reservationService: ReservationService,
              private router: Router, // navigate to other pages
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.refreshData();
  }

  refreshData() {
    this.reservationService.getReservations().subscribe(
      response => this.handleSuccessfulResponse(response)
    );
    this.activatedRoute.queryParams.subscribe(
      (params) => {
        // this.action = params.action;x
        // const id = params.id;
        // this.viewReservedBook(id);
        // this.viewReservedUser(id);
        /*if (id) { // show the view page for the selected user
          this.selectedBook = this.books.find(book => {
            return book.id === +id;
          });
        }*/
      }
    );
  }

  handleSuccessfulResponse(response) {
    this.reserve = new Array<Reservation>();
    this.ress = response;

    for (const res of this.ress) {
      const bookWithRetrivedImageField = new Reservation();
      bookWithRetrivedImageField.id = res.id;
      bookWithRetrivedImageField.bookName = res.bookName;

      // bookWithRetrivedImageField.retrievedImage = 'data:image/jpeg;base64,' + book.picByte;
      bookWithRetrivedImageField.userName = res.userName;
      // bookWithRetrivedImageField.authors = book.authors;
      this.reserve.push(bookWithRetrivedImageField);
    }
  }

  viewReservation(id: number) {
    this.reservationService.getReservationById(id);
  }

  /*
  addUser() {
    this.httpClientService.addUser(this.user).subscribe(
      (user) => {
        // this.router.navigate(['admin', 'users']);
        this.userAddedEvent.emit();
        this.router.navigate(['users']);
      }
    );
  }
  * */

  viewReservedUser(id: number) {
    this.reservationService.getReservedUser(id);
    console.log('viewReservedUSER: ' + this.reservationService.getReservedUser(id));
    console.log('refreshData: ' + this.refreshData());
  }

  viewReservedBook(id: number) {
    this.reservationService.getReservedBook(id);
    console.log('viewReservedBOOk ' + this.reservationService.getReservedBook(id));
  }
}


