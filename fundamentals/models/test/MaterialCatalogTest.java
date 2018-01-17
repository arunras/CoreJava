package core.fundamentals.models.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import core.fundamentals.models.Book;
import core.fundamentals.models.Material;
import core.fundamentals.models.MaterialCatalogMemoryVersion;
import core.fundamentals.models.MaterialNotFoundException;

public class MaterialCatalogTest {
  private MaterialCatalogMemoryVersion bc;
  private Book book1; 

  public MaterialCatalogTest() {
    bc = new MaterialCatalogMemoryVersion();
    book1 = new Book("1", "Learning Java", "", "", "", 0);
    bc.addMaterial(book1);
    System.out.println("Constructor being run");
  }

  @Test
  public void testAddABook() {
    int initialNumber = bc.getNumberOfMaterials();

    Book book = new Book("2", "", "", "", "", 0);
    bc.addMaterial(book);

    assertTrue(initialNumber == bc.getNumberOfMaterials() - 1);
  }

  @Test
  public void testFindABook() {
    try {
      Material foundBook = bc.findMaterial("Learning Java");
    } catch (MaterialNotFoundException e) {
      fail("Book not found");
    }
  } 

  @Test
  public void testFindABookIgnoringCase() {
    try {
      Material foundBook = bc.findMaterial("learning Java");
    } catch (MaterialNotFoundException e) {
      fail("Book not found");
    }
  } 

  @Test
  public void testFindABookWithExtraSpaces() {
    try {
      Material foundBook = bc.findMaterial(" learning Java ");
    } catch (MaterialNotFoundException e) {
      fail("Book not found");
    }
  } 

  @Test
  public void testFindABookThatDoesntExist() throws MaterialNotFoundException {
    try {
      Material foundBook = bc.findMaterial("Learning More Java"); 
      fail("Book was found");
    } catch (MaterialNotFoundException e) {
      //Exception was expected, therefore test passed.
    }
  } 
}
