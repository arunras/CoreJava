package core.fundamentals.ui;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;

import core.fundamentals.models.Book;

public class ImprovingArrays {
  public static void main(String[] args) {
    System.out.println("ArrayList");
    ArrayList <String> myArrayList = new ArrayList<>();
    myArrayList.add("first arrayItem");
    boolean result = myArrayList.add("second arrayItem");
    myArrayList.add("third arrayItem");
    myArrayList.add("fourth arrayItem");
    System.out.println("size: " + myArrayList.size());
    myArrayList.remove(1);
    myArrayList.add("first arrayItem");
    myArrayList.add(1, "first arrayItem");
    for (int i = 0; i < myArrayList.size(); i++) {
      System.out.println(myArrayList.get(i));
    }
    System.out.println("size: " + myArrayList.size());

    System.out.println("\nHashSet");
    HashSet <String> myHashSet = new HashSet<>();
    myHashSet.add("first hashsetItem");
    myHashSet.add("second hashsetItem");
    myHashSet.add("third hashsetItem");
    myHashSet.add("fourth hashsetItem");
    System.out.println("size: " + myHashSet.size());
    myHashSet.remove("second hashsetItem");
    System.out.println("size: " + myHashSet.size());
    Iterator <String> myIterator = myHashSet.iterator();    
    while (myIterator.hasNext()) {
      System.out.println(myIterator.next());
    }

    System.out.println("\nHashMap");    
    HashMap <String, Book> myHashMap = new HashMap<>();
    Book book1 = new Book(1, "first book", "", "", "", 100);
    Book book2 = new Book(2, "second book", "", "", "", 100);
    Book book3 = new Book(3, "third book", "", "", "", 100);
    myHashMap.put(book1.getTitle(), book1);
    myHashMap.put(book2.getTitle(), book2);
    myHashMap.put(book3.getTitle(), book3);
    System.out.println("size: " + myHashMap.size());
    myHashMap.remove(book2.getTitle());
    System.out.println("size: " + myHashMap.size());
    myHashMap.put(book2.getTitle(), book2);
    Iterator <Book> myValues = myHashMap.values().iterator();
    while (myValues.hasNext()) {
      System.out.println(myValues.next());
    }
    Iterator <String> myKeys = myHashMap.keySet().iterator();
    while (myKeys.hasNext()) {
      System.out.println(myKeys.next());
    }

  }
}











