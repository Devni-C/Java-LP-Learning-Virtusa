import { Component, OnInit } from '@angular/core';
import {Book} from '../../../models/Book';
import {BookService} from '../../../services/book/book.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  books: Array<Book>;
  booksReceived: Array<Book>;
  selectedBook: Book;
  action: string;

  constructor(private bookService: BookService,
              private activatedRoute: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    this.refreshData();
  }

  refreshData() {
    this.bookService.getBooks().subscribe(
      response => this.handleSuccessfulResponse(response)
    );

    this.activatedRoute.queryParams.subscribe(
      (params) => {
        this.action = params.action;
        const id = params.id;
        if (id) { // show the view page for the selected user
          this.selectedBook = this.books.find(book => {
            return book.id === +id;
          });
        }
      }
    );
  }

  handleSuccessfulResponse(response) {
    this.books = new Array<Book>();
    this.booksReceived = response;

    for (const book of this.booksReceived) {
      const bookWithRetrivedImageField = new Book();
      bookWithRetrivedImageField.id = book.id;
      bookWithRetrivedImageField.title = book.title;

      bookWithRetrivedImageField.retrievedImage = 'data:image/jpeg;base64,' + book.picByte;
      bookWithRetrivedImageField.authors = book.authors;
      bookWithRetrivedImageField.isbn = book.isbn;
      // bookWithRetrivedImageField.authors = book.authors;
      this.books.push(bookWithRetrivedImageField);
    }
  }

  addBook() {
    this.selectedBook = new Book();
    this.router.navigate(['books'], {queryParams: {action: 'add'}});
  }

  viewBook(id: number) {
    this.router.navigate(['books'], {queryParams: {id, action: 'view'}});
  }
}
