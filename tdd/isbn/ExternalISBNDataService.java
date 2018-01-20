package core.tdd.isbn;

public interface ExternalISBNDataService {
  public Book lookup(String isbn);
}
