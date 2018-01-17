package core.fundamentals.models.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import core.fundamentals.models.Book;
import core.fundamentals.models.BookCatalog;
import core.fundamentals.models.BookNotFoundException;

public class BookCatalogTest {
  private BookCatalog bc;
  private Book book1; 

  public BookCatalogTest() {
    bc = new BookCatalog();
    book1 = new Book("1", "Learning Java", "", "", "", 0);
    bc.addBook(book1);
    System.out.println("Constructor being run");
  }

  @Test
  public void testAddABook() {
    int initialNumber = bc.getNumberOfBooks();

    Book book = new Book("2", "", "", "", "", 0);
    bc.addBook(book);

    assertTrue(initialNumber == bc.getNumberOfBooks() - 1);
  }

  @Test
  public void testFindABook() {
    try {
      Book foundBook = bc.findBook("Learning Java");
    } catch (BookNotFoundException e) {
      fail("Book not found");
    }
  } 

  @Test
  public void testFindABookIgnoringCase() {
    try {
      Book foundBook = bc.findBook("learning Java");
    } catch (BookNotFoundException e) {
      fail("Book not found");
    }
  } 

  @Test
  public void testFindABookWithExtraSpaces() {
    try {
      Book foundBook = bc.findBook(" learning Java ");
    } catch (BookNotFoundException e) {
      fail("Book not found");
    }
  } 

  @Test
  public void testFindABookThatDoesntExist() throws BookNotFoundException {
    try {
      Book foundBook = bc.findBook("Learning More Java"); 
      fail("Book was found");
    } catch (BookNotFoundException e) {
      //Exception was expected, therefore test passed.
    }
  } 
}
