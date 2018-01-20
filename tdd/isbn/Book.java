package core.tdd.isbn;

public class Book {
  private String isbn;
  private String title;
  private String author;

  public Book(String isbn, String title, String author) {
    super();
    this.isbn = isbn;
    this.title = title;
    this.author = author;
  }

  public String getISBN() {
    return isbn;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }
  
}
