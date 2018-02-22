package core.jee.employeemanagement.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import core.jee.employeemanagement.EmployeeManagementServiceLocal;
import core.jee.employeemanagement.ServiceUnavailableException;
import core.jee.employeemanagement.dataaccess.EmployeeNotFoundException;
import core.jee.employeemanagement.domain.Employee;

@Stateless
@Path("/employees")
public class EmployeeResource {
	@Inject
	private EmployeeManagementServiceLocal service;
	
	@GET
	@Produces({"application/JSON"})
	public Response getAllEmployeesWhereIdBetween(@DefaultValue("0") @QueryParam("firstId") Integer firstId, @QueryParam("secondId") Integer secondId) {
		if (firstId == 0 && secondId == null) {
			//GenericEntity<List<Employee>> employees = new GenericEntity<List<Employee>>(service.getAllEmployees()) {};
			return Response.ok(service.getAllEmployees()).build();
		}
		
		if (firstId != null && secondId != null) {
			return Response.ok(service.getAllEmployeesWhereIdBetween(firstId, secondId)).build();
		}
		
		return Response.status(404).build();
	}
	
	@GET
	@Produces({"application/JSON", "application/XML"})
	@Path("{employeeNo}")
	public Response findEmployeeById(@PathParam("employeeNo") int id, @Context HttpHeaders headers) {
		System.out.println("HEADERS : " + headers.getRequestHeaders());
		try {
			Employee result = service.getById(id);
			return Response.ok(result).build();
		} catch (EmployeeNotFoundException e) {
			return Response.status(404).build();
		}
	}
	
	@POST
	@Produces({"application/JSON", "application/XML"})
	@Consumes("application/JSON")
	public Response createEmployee(Employee employee) {
		try {
			service.registerEmployee(employee);
			URI uri = null;
			try {
				uri = new URI("/employees/104");
			} catch (URISyntaxException e) {}
			return Response.created(uri).build();
		} catch (ServiceUnavailableException e) {
			return Response.status(504).build();
		}
	}
	
	@DELETE
	@Path("{employeeNo}")
	public Response deleteEmployee(@PathParam("employeeNo") int id) {
		try {
			service.deleteEmployee(id);
			return Response.status(204).build();
		} catch (EmployeeNotFoundException e) {
			return Response.status(404).build();
		}
	}
	
	@PUT
	@Path("{employeeNo}")
	@Produces({"application/JSON", "application/XML"})
	@Consumes("application/JSON")
	public Response updateEmployee(@PathParam("employeeNo") int id, Employee e) {
		try {
			service.updateEmployee(id, e.getJobRole(), e.getSalary());
			return Response.ok(service.getById(id)).build();
		} catch (EmployeeNotFoundException e1) {
			return Response.status(404).build();
		}
	}
}











