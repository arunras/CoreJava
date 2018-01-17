package core.fundamentals.models;

import java.util.HashSet;

public class CustomerRecords {
  private HashSet<Customer> records;

  public CustomerRecords() {
    records = new HashSet<>();
  }

  public void add(Customer customer) {
    records.add(customer);
  }

  public Customer findByName(String name) throws CustomerNotFoundException {
    for (Customer customer : records) {
      if (customer.getMailingName().equals(name)) {
        return customer;
      }
    }
    throw new CustomerNotFoundException();
  }

  public int getNumberOfCustomer() {
    return records.size();
  }
}
