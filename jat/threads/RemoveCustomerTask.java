package core.jat.threads;

public class RemoveCustomerTask implements Runnable {
  private CustomerList customerList;

  public RemoveCustomerTask(CustomerList customerList) {
    this.customerList = customerList;
  }

  @Override
  public void run() {
    while (true) {
      Customer nextCustomer = customerList.getFromList();
      System.out.println(Thread.currentThread().getName() + " removed customer " + nextCustomer.getId());
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
