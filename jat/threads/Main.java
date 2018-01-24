package core.jat.threads;

public class Main {
  public static void main(String[] args) {
    // From 23. Avoiding Deadlocks
    CustomerList customerList = new CustomerList();
    Thread removeCustomers = new Thread(new RemoveCustomerTask(customerList));
    removeCustomers.start();
    System.out.println("Started Thread to remove customers");

    for (int i = 0; i < 5; i++) {
      Thread addCustomers = new Thread(new AddCustomerTask(customerList, i*100));
      addCustomers.start();
      System.out.println("Started Thread to add customers");
    }

    // From 21. Collections Thread Safty
    /*
    CustomerManager cm = new CustomerManager();
    GenerateCustomerTask task = new GenerateCustomerTask(cm);
    for (int i = 0; i < 10; i++) {
      Thread t = new Thread(task);
      t.start();
    }

    // main thread is now acting as the monitoring thread
    while (true) {
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      cm.howManyCustomer();
      cm.displayCustomers();
    }
    */

    // From 20. Synchronization and Thread-Safe
    /*
    System.out.println("Starting");
    NumbersTask task = new NumbersTask();
    for (int i = 1; i <=5; i++) {
      Thread numbersThread = new Thread(task);
      numbersThread.start();
    }
    System.out.println("Finished");
    */
  }
}
