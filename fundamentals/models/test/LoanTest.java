package core.fundamentals.models.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import core.fundamentals.models.Book;
import core.fundamentals.models.Customer;
import core.fundamentals.models.Loan;
import core.fundamentals.utilities.GenderType;

class LoanTest {

	@Test
	public void testDueDate() {
		Book book = new Book(0, "", "", "", "", 0);
		Customer customer = new Customer("", "", "", "", "", "", 0, GenderType.MALE);
		Loan loan = new Loan(0, customer, book);
	
    GregorianCalendar gcExpected = new GregorianCalendar();
    gcExpected.add(GregorianCalendar.DAY_OF_WEEK, 14);

    GregorianCalendar gcActual = new GregorianCalendar();
    gcActual.setTime(loan.getDueDate());

    assertEquals(gcExpected.get(GregorianCalendar.YEAR), gcActual.get(GregorianCalendar.YEAR), "Checking Year"); 
    assertEquals(gcExpected.get(GregorianCalendar.MONTH), gcActual.get(GregorianCalendar.MONTH), "Checking Year");
    assertEquals(gcExpected.get(GregorianCalendar.DAY_OF_MONTH), gcActual.get(GregorianCalendar.DAY_OF_MONTH), "Checking Year"); 
      

		
		
		
		
		
		//fail("Not yet implemented");
	}

}
