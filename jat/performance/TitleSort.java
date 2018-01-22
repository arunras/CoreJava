package core.jat.performance;

import java.util.Comparator;

import core.jat.sortingObjects.Book;

public class TitleSort implements Comparator<Book> {
  @Override
  public int compare(Book arg0, Book arg1) {
    return arg0.getTitle().compareTo(arg1.getTitle());
  }
}
