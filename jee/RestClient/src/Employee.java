import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
	private int id;
	private String firstName;
	private String jobRolel;
	private int salary;
	private String surname;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getJobRolel() {
		return jobRolel;
	}
	public void setJobRolel(String jobRolel) {
		this.jobRolel = jobRolel;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String toString() {
		return "Employee (" + this.id + ") -" + this.firstName + " " + this.surname; 
	}

}
