package core.tdd.isbn;

public class StockManager {
  private ExternalISBNDataService webService;
  private ExternalISBNDataService dbService;
  
  public void setWebService(ExternalISBNDataService webService) {
    this.webService = webService;
  }

  public void setDbService(ExternalISBNDataService dbService) {
    this.dbService = dbService;
  }

  public String getLocatorCode(String isbn) {
    Book book = dbService.lookup(isbn);
    if (book == null) book = webService.lookup(isbn);

    StringBuilder locator = new StringBuilder();
    locator.append(isbn.substring(isbn.length() - 4));
    locator.append(book.getAuthor().substring(0, 1));
    locator.append(book.getTitle().split(" ").length);
    return locator.toString();
  }
}
