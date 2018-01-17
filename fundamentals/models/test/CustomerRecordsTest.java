package core.fundamentals.models.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import core.fundamentals.models.Customer;
import core.fundamentals.models.CustomerNotFoundException;
import core.fundamentals.models.CustomerRecords;
import core.fundamentals.utilities.GenderType;

class CustomerRecordsTest {
  private CustomerRecords records;

  public CustomerRecordsTest() {
    records = new CustomerRecords();
    Customer newCustomer = new Customer("Mrs", "Sandra", "Smith", "2 High Street", "12346", 
        "sandra@math.com", 3, GenderType.FEMALE);
    records.add(newCustomer);
  }

	@Test
	public void testAddCustomer() {
    Customer newCustomer = new Customer("Mr", "Math", "Greencroft", "1 High Street", "12345", 
        "math@math.com", 1, GenderType.MALE);

    int initialSize = records.getNumberOfCustomer();

    records.add(newCustomer);
    assertTrue(initialSize == records.getNumberOfCustomer() - 1);
	}

  @Test
  public void testFindCustomer() {
    try {
      Customer foundCustomer = records.findByName("Mrs S Smith");
    } catch (CustomerNotFoundException expected) {
      fail("Customer not found");
    }
  }
  //TODO: fix the bug
  @Test
  public void testNoDuplicates() {
    Customer newCustomer = new Customer("Mrs", "Sandra", "Smith", "2 High Street", "12346", 
        "sandra@math.com", 3, GenderType.FEMALE);
    records.add(newCustomer);
    records.add(newCustomer);
    records.add(newCustomer);
    records.add(newCustomer);

    assertEquals(1, records.getNumberOfCustomer());

  }

}
