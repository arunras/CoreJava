package core.jat.threads;

public class EvenTask implements Runnable {
  EvenNumberHolder evenNumberHolder;

  public EvenTask(EvenNumberHolder evenNumberHolder) {
    this.evenNumberHolder = evenNumberHolder;
  }
  @Override
  public void run() {
    int i = 0;
    while (true) {
      int value = evenNumberHolder.getNextEven();
      System.out.println("Thread " + Thread.currentThread().getName() + " has got value " + value);
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      i++;
    } 
  }
}
