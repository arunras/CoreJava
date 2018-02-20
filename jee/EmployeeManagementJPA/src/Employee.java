import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  private String firstName;
  private String surname;
  private String jobRole;
  private int salary;

  public Employee() {
  		// required by JPA
  }
  
  public Employee(String firstName, String surname, String jobRole, int salary) {
    super();
    this.firstName = firstName;
    this.surname = surname;
    this.jobRole = jobRole;
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "Employee: " + this.firstName + " " + this.surname;
  }
}
