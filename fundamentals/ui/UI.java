package core.fundamentals.ui;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import core.fundamentals.models.Book;
import core.fundamentals.models.Material;

public class UI {
  public void printHeader() {
    System.out.println("BookID  Title                 Author");
  }

  public void printBook(Book book) {
    System.out.println(fixLengthString(book.getID(), 6) + "  " + fixLengthString(book.getTitle(), 20)
        + "  " + fixLengthString(book.getAuthor(), 20));
  }

  public String fixLengthString(String start, int length) {
    //TODO: fix string padding problem
    if (start.length() >= length) {
      return start.substring(0, length);
    } else {
      while (start.length() < length) {
        start += " ";
      }
      return start;
    }
  }

  public String fixLengthString(int start, int length) {
    String startString = String.valueOf(start);
    return fixLengthString(startString, length);
  }

  public void printMaterialCatalog(Map<String, Material> map) {
  		for (Material nextMaterial : map.values()) {
        System.out.println(nextMaterial.toString());
  		}
  }
}
