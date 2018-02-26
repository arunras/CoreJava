public class Engine extends CarPart {
  private String name;
  private String code;
  private String displacement;
  private int cylinder;

  public Engine(String name, String code, String displacement, int cylinder, int condition) {
    super(condition);
    this.name = name;
    this.code = code;
    this.displacement = displacement;
    this.cylinder = cylinder;
  }

  @Override
  public void function() {
    //TODO: print unique message of it's states
    System.out.println("\n==" + name + " Engine=="); 
    System.out.println("NAME: " + name);
    System.out.println("CODE: " + code);
    System.out.println("DISPLACEMENT: " + displacement);
    System.out.println("CYLINDER: " + cylinder);
    this.status();
  }
}
