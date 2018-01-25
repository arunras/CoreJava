package core.jat.threads;

import java.util.concurrent.Callable;

public class NumbersTaskPool implements Callable<Double> {
  private int someVariable;

  private Double longRunningMethod() throws InterruptedException {
    Double j = 1.01;
    for (long l = 1; l < 100_000_000L; l++) {
      j+= 1.01;
      if (Thread.interrupted()) {
        throw new InterruptedException();
      }
    }
    return j;
  }

  @Override
  public Double call() {
    System.out.println("Task Number " + Thread.currentThread().getName() + " is starting");
    Double result = 0d;
    try {
      result = longRunningMethod();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    return result;
  }
}
