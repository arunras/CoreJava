package core.jat.generics;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
  public static void main(String[] args) {
    List<Customer> customers = new ArrayList<>();

    Customer customer1 = new Customer(1, "Simon Brown", "10 East Stree");
    Customer customer2 = new Customer(2, "Jean White", "16 North Road");
    Customer customer3 = new Customer(1, "Alison Green", "9 South Gargens");

    customers.add(customer1);
    customers.add(customer2);
    customers.add(customer3);

    Iterator<Customer> iterator = customers.iterator();
    while (iterator.hasNext()) {
      Customer nextCustomer = iterator.next();
      System.out.println(nextCustomer.getName());
    }

    for (Customer nextCustomer: customers) {
      System.out.println(nextCustomer.getAddress());
    }
  }
}
