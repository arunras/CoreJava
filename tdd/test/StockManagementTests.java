package core.tdd.test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import static org.mockito.Mockito.*;

import core.tdd.isbn.*;

public class StockManagementTests {
  ExternalISBNDataService testWebService;
  ExternalISBNDataService testDbService;
  StockManager stockManager;

  @Before
  public void setup() {
    testWebService = mock(ExternalISBNDataService.class);
    testDbService = mock(ExternalISBNDataService.class);
    stockManager = new StockManager();
    stockManager.setWebService(testWebService);
    stockManager.setDbService(testDbService);

  }

  @Test
  public void testCanGetACorrectLocatorCode() {
    /*
    ExternalISBNDataService testWebService = new ExternalISBNDataService() {
      @Override
      public Book lookup(String isbn) {
        return new Book(isbn, "Of Mice and Men", "J. Steinbeck");
      }
    };

    ExternalISBNDataService testDbService = new ExternalISBNDataService() {
      @Test
      public Book lookup(String isbn) {
        return null;
      }
    };
    */

    when(testWebService.lookup("0140177396")).thenReturn(new Book("0140177396", "Of Mice and Men", "J. Steinbeck"));
    when(testDbService.lookup("0140177396")).thenReturn(null);

    String isbn = "0140177396";
    String locatorCode = stockManager.getLocatorCode(isbn);
    assertEquals("7396J4", locatorCode);
  }

  @Test
  public void dbIsUsedIfDataIsPresent() {
    when(testDbService.lookup("0140177396")).thenReturn(new Book("0140177396", "abc", "abc"));

    String isbn = "0140177396";
    String locatorCode = stockManager.getLocatorCode(isbn);
    verify(testDbService, times(1)).lookup("0140177396");
    verify(testWebService, never()).lookup(anyString());
  }

  @Test
  public void webServiceIsUsedIfDataIsNotPresentInDb() {
    when(testDbService.lookup("0140177396")).thenReturn(null); 
    when(testWebService.lookup("0140177396")).thenReturn(new Book("0140177396", "abc", "abc"));

    String isbn = "0140177396";
    String locatorCode = stockManager.getLocatorCode(isbn);
    verify(testDbService, times(1)).lookup("0140177396");
    verify(testWebService).lookup("0140177396");
  }
}
