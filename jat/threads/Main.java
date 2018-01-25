package core.jat.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
  public static void main(String[] args) {
    lockCondition();
  }

  public static void lockCondition() {
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
  }

  public static void threadPool() {
    System.out.print("Starting");
    NumbersTaskPool task = new NumbersTaskPool();

    ExecutorService pool =  Executors.newFixedThreadPool(2);
    Future<Double> result = pool.submit(task);

    while (!result.isDone()) {
      System.out.println("still waiting");
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    
    try {
    System.out.println(result.get());
    } catch (InterruptedException e) {

    } catch (ExecutionException e) {

    }
    System.out.println("Finished");

  }

  public static void threadProcessFlow() {
    System.out.println("Starting");
    NumbersTask task = new NumbersTask();
    Thread numbersThread1 = new Thread(task);
    numbersThread1.start();

    Thread numbersThread2 = new Thread(task);
    numbersThread2.start();
  
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    //numbersThread1.interrupt();
    //numbersThread2.interrupt();
    try {
      numbersThread1.join(); 
      numbersThread2.join();
    } catch (InterruptedException e) {

    }

    System.out.println("Finished");
   
  }

  public void avoidingDeadlocks() {
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
  }

  public void synchronizationAndThreadSafe() {
    // From 20. Synchronization and Thread-Safe
    System.out.println("Starting");
    NumbersTask task = new NumbersTask();
    for (int i = 1; i <=5; i++) {
      Thread numbersThread = new Thread(task);
      numbersThread.start();
    }
    System.out.println("Finished");
  }

  public void collectionThreadSafty() {
    // From 21. Collections Thread Safty
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
  }
}
