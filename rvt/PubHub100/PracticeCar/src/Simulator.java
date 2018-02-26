/*
 ===========================================
 Project: PracticeCar                       |
 Revature: PubHub 100             	        |
 Name: Arun Rasmey                          |
 Date: Feb 26, 2018                         |
 ===========================================
*/

public class Simulator {
  public static void main(String[] args) {
    Car car = new Car("BMW", "X5");
    car.printModel();
    car.run();
  }
}
