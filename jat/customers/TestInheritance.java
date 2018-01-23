package core.jat.customers;

import java.util.List;
import java.util.ArrayList;

public class TestInheritance {
  public static void main(String[] args) {
    List<Number> myNumbers = new ArrayList<>();

    myNumbers.add(16);
    myNumbers.add(107L);
    myNumbers.add(152.09);

    Double total = 0d;
    for (Number number: myNumbers) {
      total += number.doubleValue();
    }

    System.out.println("The total is " + total);
  }
}
