public class CarPart implements Functional {
  private int condition; // 100-0

  public CarPart(int condition) {
    this.setCondition(condition);
  }

  @Override
  public void function() {
    System.out.println("The details of each part.");
  }

  public void status() {
    System.out.println("CONDITION: " + this.getCondition());
  }

  public void setCondition(int condition) {
    this.condition = condition;
  }

  public int getCondition() {
    return condition;
  }
}
