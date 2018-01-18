package core.fundamentals.models;

public class DVD extends Material {
  private String director;
  private String catalogNo;
  private int runningTime;
  private boolean licensed;

  public DVD(String id, String title, String branch, String director, String catalogNo, int runningTime) {
    super(id, title, branch);
    this.director = director;
    this.catalogNo = catalogNo;
    this.runningTime = runningTime;
    this.licensed = false;
  }

  public void license() {
    licensed = true;
  }

  public boolean getLicensed() {
    return licensed;
  }

  public int getRunningTime() {
    return runningTime;
  }

  public String getCatalogNumber() {
    return catalogNo;
  }

  public int getLoanPeriod() {
    return 7;
  }

  @Override
  public boolean lend(Customer customer) {
    if (licensed) {
      return super.lend(customer);
    } else {
      return false;
    }
  }
  
  @Override
  public String toString() {
  		return "DVD: " + getID() + " " + getTitle() + " / " + director;
  }
}
