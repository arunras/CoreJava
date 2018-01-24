package core.jat.threads;

public class Main {
  public static void main(String[] args) {
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
