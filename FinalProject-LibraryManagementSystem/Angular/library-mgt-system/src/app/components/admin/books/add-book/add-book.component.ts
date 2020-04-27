import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Book} from '../../../../models/Book';
import {BookService} from '../../../../services/book/book.service';
import {ActivatedRoute, Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {
  @Input()
  book: Book;

  @Output()
  bookAddedEvent = new EventEmitter();

  public selectedFile;
  imgURL: any;

  constructor(private bookService: BookService,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              private httpClient: HttpClient) {
  }

  ngOnInit(): void {
  }

  public onFileChanged(event) {
    console.log(event);
    this.selectedFile = event.target.files[0];

    // display the selected image
    let reader = new FileReader();
    reader.readAsDataURL(event.target.files[0]);
    reader.onload = (event2) => {
      this.imgURL = reader.result;
    };
  }

  saveBook() {
    if (this.book.id == null) {

      const uploadData = new FormData();
      uploadData.append('imageFile', this.selectedFile, this.selectedFile.name);
      this.selectedFile.imageName = this.selectedFile.name;

      this.httpClient.post('http://localhost:8888/book/upload', uploadData, {observe: 'response'})
        .subscribe((response) => {
          if (response.status === 200) {
            this.bookService.addBook(this.book).subscribe(
              (book) => {
                this.bookAddedEvent.emit();
                this.router.navigate(['books']);
              }
            );
            console.log('Image uploaded successfully');
          } else {
            console.log('Image uploading failed');
          }
        });
    } else {
      this.bookService.updateBook(this.book).subscribe(
        (book) => {
          this.bookAddedEvent.emit();
          this.router.navigate(['books']);
        }
      );
    }
  }
}
