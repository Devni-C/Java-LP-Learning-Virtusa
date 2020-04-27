import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Book} from '../../../../models/Book';
import {BookService} from '../../../../services/book/book.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-view-books',
  templateUrl: './view-books.component.html',
  styleUrls: ['./view-books.component.css']
})
export class ViewBooksComponent implements OnInit {

  @Input()
  book: Book;

  @Output()
  bookDeletedEvent = new EventEmitter();

  constructor(private bookService: BookService,
              private router: Router) { }

  ngOnInit(): void {
  }

  deleteBook() {
    this.bookService.deleteBook(this.book.id).subscribe(
      (book) => {
        this.bookDeletedEvent.emit();
        this.router.navigate(['books']);
      }
    );
  }

  editBook() {
    this.router.navigate(['books'], {queryParams: {action: 'edit', id: this.book.id}});
  }
}
