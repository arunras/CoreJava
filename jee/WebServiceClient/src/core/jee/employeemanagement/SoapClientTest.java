package core.jee.employeemanagement;
import java.util.List;

public class SoapClientTest {

	public static void main(String[] args) {
		EmployeeManagementWebService service = new EmployeeManagementWebserviceImplementationService().getEmployeeManagementWebServicePort();
		
		Employee newEmployee = new Employee();
		newEmployee.setFirstName("Jim");
		newEmployee.setSurname("Brown");
		newEmployee.setJobRole("Dancer");
		newEmployee.setSalary(1000);
		try {
			service.registerNewEmployee(newEmployee);
		} catch (ServiceUnavailableException_Exception e) {
			System.out.println("A third party connection was down, please try again.");
		}
		
		List<Employee> employees = service.getAllEmployees();
		for (Employee employee : employees) {
			System.out.println("Id:" + employee.getId() + " Name:" + employee.getFirstName() + " Surname:" + employee.getSurname());
		}
		
		Employee employee11 = service.getEmployeeById(1);
		System.out.println();
		System.out.println("Id:" + employee11.getId() + " Name:" + employee11.getFirstName() + " Surname:" + employee11.getSurname());

	}

}
