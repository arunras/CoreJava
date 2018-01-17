package core.fundamentals.models;

public abstract class Material {
  private String id;
  private String title;
  private String branch;
  private Customer borrower;

  public Material(String id, String title, String branch) {
    this.id = id;
    this.title = title;
    this.branch = branch;
  }

  //Must be overriden
  public abstract int getLoanPeriod();


  public String getID() {
    return id;
  }
  public String getTitle() {
    return title;
  }

  public void relocate(String newBranch) {
    this.branch = newBranch;
  }

  public boolean lend(Customer customer) {
    if (borrower == null) {
      borrower = customer;
      return true;
    } else {
      return false;
    }
  }
  
  @Override
  public String toString() {
    return title;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (getClass() == obj.getClass()) {
      Material otherClass = (Material) obj;
      return (id == otherClass.id) ? true : false;
    } else {
      return false;
    }
  }
}









