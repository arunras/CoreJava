import java.util.ArrayList;
import java.util.List;

public class Car {
  private String make;
  private String model;
  private List<CarPart> carParts;

  public Car(String make, String model) {
    this.make = make;
    this.model = model;

    CarPart engine = new Engine("V8", "OHV V8", "2.6-3.2 L", 5, 90);
    CarPart fuelTank = new FuelTank("Gasoline", 15, 10, 80);
    CarPart wheel = new Wheel("Run-flat all-season", "17 x 7.5 front and rear", "225/50 front and rear", 9 , 99);
    CarPart transmission = new Transmission("8-speed Sport Automatic", "4.71 / 3.14 / 2.10", 95);    
    
    carParts = new ArrayList<>();
    carParts.add(engine);
    carParts.add(fuelTank);
    carParts.add(wheel);
    carParts.add(transmission);
  }

  public void run() {
    for (CarPart part : carParts) {
      part.function();
    }
  }

  public void printModel() {
    System.out.println(make + " " + model);
  }
}

