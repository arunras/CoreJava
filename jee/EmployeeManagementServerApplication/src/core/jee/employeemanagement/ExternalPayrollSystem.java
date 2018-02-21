package core.jee.employeemanagement;

import javax.ejb.Stateless;

import core.jee.employeemanagement.domain.Employee;

@Stateless
public class ExternalPayrollSystem {
	public void enrollEmployee(Employee newEmployee) throws ServiceUnavailableException {
		double test = Math.random();
		if (test < 0.5) {
			throw new ServiceUnavailableException();
		} else {
			// Do something
		}
	}
}
