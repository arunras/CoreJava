public class FuelTank extends CarPart {
  private String fuelType;
  private int capacity;
  private int fuelLevel;
  
  public FuelTank(String fuelType, int capacity, int fuelLevel, int condition) {
    super(condition);
    this.fuelType = fuelType;
    this.capacity = capacity;
    this.fuelLevel = fuelLevel;
  }

  @Override
  public void function() {
    //TODO: print unique message
    System.out.println("\n" + "==Fuel Tank=="); 
    System.out.println("FUEL TYPE: " + fuelType);
    System.out.println("CAPACITY (gallons): " + capacity);
    System.out.println("LEVEL (gallons): " + fuelLevel);
    this.status();
  }

}
