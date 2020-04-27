export class Book {
  id: number;
  title: string;
  authors: Authors[];
  isbn: string;
  noOfCopies: number;
  isDeleted: boolean;
  picByte: string;
  retrievedImage: string;
}

export interface Authors {
  authorName: string;
}
