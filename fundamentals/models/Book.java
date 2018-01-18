package core.fundamentals.models;

public class Book extends Material {

  private String author;
  private String isbn;
  private int noOfPages;

  public Book(String id, String title, String author, String isbn, String branch, int noOfPages) {
    super(id, title, branch);
    this.author = author;
    this.isbn = isbn;
    this.noOfPages = noOfPages;
  }

  public String getAuthor() {
    return author;
  }

  public String getIsbn() {
    return isbn;
  }

  public int getNumberOfPages() {
    return noOfPages;
  }
  public void sendForRepair() {
    System.out.println("Book has been sent to repair");
  }

  public int getLoanPeriod() {
    return 21;
  }
  
  @Override
  public String toString() {
  		return "Book: " + getID() + " " + getTitle() + " / " + getAuthor();
  }
}
