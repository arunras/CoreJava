package core.fundamentals.models;

public class BookCatalog {
  private Book[] bookArray = new Book[10];
  private int nextPosition = 0;

  public Book[] getBookArray() {
    return bookArray;
  }

  public int getNumberOfBooks() {
    return nextPosition;
  }

  public void addBook(Book newBook) {
    bookArray[nextPosition] = newBook;
    nextPosition++;
  }

  public Book findBook(String title) throws BookNotFoundException{
  		title = title.trim();
    for (int i = 0; i < nextPosition; i++) {
      if (bookArray[i].getTitle().equalsIgnoreCase(title)) {
        return bookArray[i];
      }
    } 
    throw new BookNotFoundException();
  }
}
