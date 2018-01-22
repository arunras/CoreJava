package core.jat.performance;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import core.jat.sortingObjects.Book;

public class Main {
  public static void main(String[] args) {
    Random randomGenerator = new Random();
    List<Book> list = new LinkedList<>();
    for (int i = 0; i< 1_000_000; i++) {
      list.add(new Book(i, "test" + randomGenerator.nextInt(2_000_000),"test" + i));
    }

    Long start = System.nanoTime();
    Collections.sort(list, new TitleSort());
    Long end = System.nanoTime();
    /*
    for (Book nextBook : list) {
    	  System.out.println(nextBook);
    }
    */
    System.out.println("Time: " + (end - start) / 1e6);
  }
}
