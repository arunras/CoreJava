import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class TestClient {
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		/*
		WebTarget target = client.target("http://localhost:8080/EmployeeManagement/webservice/employees/7");
		Invocation invocation = target.request().buildGet();
		Response response = invocation.invoke();
		*/
//		Response response = client.target("http://localhost:8080/EmployeeManagement/webservice/employees/123")
//				.request("application/JSON").buildGet().invoke();
//		System.out.println(response.getHeaders());
//		System.out.println(response.getStatus());
//		
//		
//		System.out.println(response.readEntity(String.class));
//		response.close();
//		
//		Employee james = new Employee();
//		james.setFirstName("James");
//		james.setSurname("Green1");
//		james.setJobRole("Author");
//		james.setSalary(10000);
//		
//		Entity jamesEntity = Entity.entity(james, "application/JSON");
//		
//		response = client.target("http://localhost:8080/EmployeeManagement/webservice/employees")
//				.request().buildPost(jamesEntity).invoke();
//		System.out.println("Creating new employee returnd status code of " + response.getStatus());
//		if (response.getStatus() == 201) {
//			System.out.println(response.getHeaders().toString());
//			System.out.println(response.readEntity(String.class));
//		}
//		response.close();
		
		Response response = client.target("http://localhost:8080/EmployeeManagement/webservice/employees/117").request().buildDelete().invoke();
		System.out.println("Delete status : " + response.getStatus());
		response.close();
		
		Employee updatedEmployee = new Employee();
		updatedEmployee.setJobRole("Producer");
		updatedEmployee.setSalary(1234);	
		Entity eEntiy = Entity.entity(updatedEmployee, "application/JSON");
		response = client.target("http://localhost:8080/EmployeeManagement/webservice/employees/120").request().buildPut(eEntiy).invoke();
		System.out.println("Update status : " + response.getStatus());
		System.out.println(response.readEntity(String.class));
	
		response = client.target("http://localhost:8080/EmployeeManagement/webservice/employees")
				.request("application/JSON").buildGet().invoke();
		List<Employee> employees = response.readEntity(new GenericType<List<Employee>>(){});
		for (Employee e : employees) {
			System.out.println(e + " " + e.getJobRole() + " " + e.getSalary());
		}
	}
}
