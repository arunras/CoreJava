package core.jat.sortingObjects;

public class Book implements Comparable<Book>{
  private int id;
  private String title;
  private String author;

  public Book(int id, String title, String author) {
    this.id = id;
    this.title = title;
    this.author = author;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  @Override
  public String toString() {
    return title + " by " + author;
  }

  @Override
  public int compareTo(Book o) {
    int result = this.title.compareTo(o.getTitle());
    if (result == 0) {
      return this.author.compareTo(o.getAuthor());
    } else {
      return result;
    }
  }
}
