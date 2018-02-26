public class Transmission extends CarPart {
  private String type;
  private String gearRatio;

	public Transmission(String type, String gearRatio, int condition) {
		super(condition);
    this.type = type;
    this.gearRatio = gearRatio;
	}

  @Override
  public void function() {
    //TODO: print unique message of it's states
    System.out.println("\n==Transmission=="); 
    System.out.println("TYPE: " + type);
    System.out.println("GEAR RATIOS: " + gearRatio);
    this.status();
  }
}
