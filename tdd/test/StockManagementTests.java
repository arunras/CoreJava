package core.tdd.test;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;

import core.tdd.isbn.*;

public class StockManagementTests {
  @Test
  public void testCanGetACorrectLocatorCode() {
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

    StockManager stockManager = new StockManager();
    stockManager.setWebService(testWebService);
    stockManager.setDbService(testDbService);

    String isbn = "0140177396";
    String locatorCode = stockManager.getLocatorCode(isbn);
    assertEquals("7396J4", locatorCode);
  }

  @Test
  public void dbIsUsedIfDataIsPresent() {
    ExternalISBNDataService dbService = mock(ExternalISBNDataService.class);
    ExternalISBNDataService webService = mock(ExternalISBNDataService.class);

    when(dbService.lookup("0140177396")).thenReturn(new Book("0140177396", "abc", "abc"));
    
    StockManager stockManager = new StockManager();
    stockManager.setWebService(webService);
    stockManager.setDbService(dbService);

    String isbn = "0140177396";
    String locatorCode = stockManager.getLocatorCode(isbn);
    verify(dbService, times(1)).lookup("0140177396");
    verify(webService, never()).lookup(anyString());
  }

  @Test
  public void webServiceIsUsedIfDataIsNotPresentInDb() {
    ExternalISBNDataService dbService = mock(ExternalISBNDataService.class);
    ExternalISBNDataService webService = mock(ExternalISBNDataService.class);

    when(dbService.lookup("0140177396")).thenReturn(null); 
    when(webService.lookup("0140177396")).thenReturn(new Book("0140177396", "abc", "abc"));
    
    StockManager stockManager = new StockManager();
    stockManager.setWebService(webService);
    stockManager.setDbService(dbService);

    String isbn = "0140177396";
    String locatorCode = stockManager.getLocatorCode(isbn);
    verify(dbService, times(1)).lookup("0140177396");
    verify(webService).lookup("0140177396");
  }
}
