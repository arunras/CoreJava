package core.jat.threads;

public class AddCustomerTask implements Runnable{
  private CustomerList customerList;
  private int startNumber;

  public AddCustomerTask(CustomerList customerList, int startNumber) {
    this.customerList = customerList;
    this.startNumber = startNumber;
  }

  @Override
  public void run() {
    for (int i = startNumber; i < startNumber + 100; i++) {
      Customer customer = new Customer(i, "Customer" + i);
      customerList.addToList(customer);
      System.out.println(Thread.currentThread().getName() + " added customer " + i);
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
