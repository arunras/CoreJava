package core.jat.threads;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class CustomerListLock {
  private List<Customer> customers = new ArrayList<>();
  private Lock customersLock = new ReentrantLock();
  private Condition customersAvailable = customersLock.newCondition();
  private Condition listHasSpace = customersLock.newCondition();

  public void addToList(Customer customer) {
    customersLock.lock();
    while (customers.size()  > 100) {
      try {
        listHasSpace.await();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    customers.add(customer);
    customersAvailable.signalAll();
    customersLock.unlock();
  }

  public Customer getFromList() {
    customersLock.lock();
    try {
      while (customers.size() == 0) {
        try {
          customersAvailable.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      listHasSpace.signalAll();
      return customers.remove(0);
    } finally {
      customersLock.unlock();
    }
  }
}
