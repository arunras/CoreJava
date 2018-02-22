package core.jee.employeemanagement;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import core.jee.employeemanagement.dataaccess.EmployeeDataAccess;
import core.jee.employeemanagement.dataaccess.EmployeeNotFoundException;
import core.jee.employeemanagement.domain.Employee;

@Stateless
public class EmployeeManagementImplementation implements EmployeeManagementService, EmployeeManagementServiceLocal {
	@Inject
	private EmployeeDataAccess dao;
	
	@Inject
	private ExternalPayrollSystem payrollSystem;
	
	@Resource
	private SessionContext ctx;
	
	@Override
  public void registerEmployee(Employee employee) throws ServiceUnavailableException {
  		dao.insert(employee);
  		payrollSystem.enrollEmployee(employee);
  		
  		/*
  		try {
  			payrollSystem.enrollEmployee(employee);
  		} catch (ServiceUnavailableException e) {
  			ctx.setRollbackOnly();
  			throw e;
  		}
  		*/
  }
 
	@Override
  public List<Employee> getAllEmployees() {
  		return dao.findAll();
  }

	@Override
  public List<Employee> searchBySurname(String surname) {
    return dao.findBySurname(surname);
  }
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public double dummyInMemoryMethod() {
		return 109.293778;
	}

	@Override
	public Employee getById(int id) throws EmployeeNotFoundException {
		return dao.findById(id);
	}

	@Override
	public List<Employee> getAllEmployeesWhereIdBetween(int firstId, int secondId) {
		return dao.getAllEmployeesWhereIdBetween(firstId, secondId);
	}
	
	@Override
	public void updateEmployee(int id, String jobRole, int salary) throws EmployeeNotFoundException {
		dao.updateEmployee(id, jobRole, salary);
	}
	
	@Override
	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		dao.deleteEmployee(id);
	}
}
