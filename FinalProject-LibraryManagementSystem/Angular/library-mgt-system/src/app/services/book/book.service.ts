import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Book} from '../../models/Book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private httpClient: HttpClient) { }

  getBooks() {
    return this.httpClient.get<Book[]>('http://localhost:8888/book/getall');
  }

  addBook(newBook: Book) {
    return this.httpClient.post<Book>('http://localhost:8888/book/save', newBook);
  }

  addUploadData(selectedFile) {
    return this.httpClient.post('http://localhost:8888/book/upload', selectedFile);
  }

  deleteBook(id) {
    return this.httpClient.delete<Book>('http://localhost:8888/book/delete/', id);
  }

  updateBook(updatedBook: Book) {
    return this.httpClient.put<Book>('http://localhost:8888/book/update', updatedBook);
  }
}
