public class Wheel extends CarPart {
  private String tireType;
  private String wheelDimension;
  private String tireDimension;
  private int wearLevel;

  public Wheel(String tireType, String wheelDimension, String tireDimension, int wearLevel, int condition) {
    super(condition);
    this.tireType = tireType;
    this.wheelDimension = wheelDimension;
    this.tireDimension = tireDimension;
    this.wearLevel = wearLevel;
  }

  @Override
  public void function() {
    //TODO: print unique message
    System.out.println("\n" + "==Wheels=="); 
    System.out.println("TIRE TYPE: " + tireType);
    System.out.println("WHEEL DIMENSIONS: " + wheelDimension);
    System.out.println("TIRE DIMENSIONS: " + tireDimension);
    System.out.println("LEVEL of WEAR: " + wearLevel);
    this.status();
  }
}
