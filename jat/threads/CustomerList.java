package core.jat.threads;

import java.util.List;
import java.util.ArrayList;

public class CustomerList {
  private List<Customer> customers = new ArrayList<>();

  public void addToList(Customer customer) {
    synchronized (this) {
      while (customers.size() > 100) {
        try {
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      customers.add(customer);
      notifyAll();
    }
  }

  public Customer getFromList() {
    synchronized (this) {
      while (customers.size() == 0) {
        try {
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      notifyAll();
      return customers.remove(0);
    }
  }
}
