package core.jat.threads;

public class Customer {
  private int id;
  private String name;

  public Customer(String name) {
    super();
    this.name = name;
  }

  public Customer(int id, String name) {
    super();
    this.id = id;
    this.name = name;
  }
  
  public int getId() {
  		return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return id + " : " + name;
  }
}
