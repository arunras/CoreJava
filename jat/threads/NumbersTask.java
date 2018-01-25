package core.jat.threads;

public class NumbersTask implements Runnable {
  private int someVariable;

  private void longRunningMethod() throws InterruptedException {
    System.out.println("Starting long method");
    Double j = 1.01;
    for (long l = 1; l < 100_000L; l++) {
      j+= 1.01;
      if (Thread.interrupted()) {
        throw new InterruptedException();
      }
    }
    System.out.println("Ending long method");
  }

  @Override
  public void run() {
    for (int i = 1; i <= 1_000; i++) {
      System.out.println("Task Number " + Thread.currentThread().getName() + " is outputing number " + i);
      try {
        longRunningMethod();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
      if (Thread.interrupted()) {
        break;
      }
    }
    System.out.println("Task " + Thread.currentThread().getName() + " has finished");
  }
}
