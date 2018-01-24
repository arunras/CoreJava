package core.jat.threads;

public class Generator {
  public static void main(String[] args) {
    EvenNumberHolder evenNumberHolder = new EvenNumberHolder();
    EvenTask task = new EvenTask(evenNumberHolder);
    
    long start = System.nanoTime();
    for (int i = 0; i < 15; i++) {
      new Thread(task).start();
    }
    long end = System.nanoTime();
    long total = (long) ((end - start) / 1e3);
    System.out.println("Total time: " + total);
  }
}
