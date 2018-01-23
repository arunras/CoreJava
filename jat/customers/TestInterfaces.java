package core.jat.customers;

import java.util.List;
import java.util.ArrayList;

public class TestInterfaces {

  public static void main(String[] args) {
    //Example of inheritance
    List<CustomerInterface> customers = new ArrayList<>();
    Company c1 = new Company(1, "William Wolf", "17 Yellow Street", "Acme Industries");
    Person p1 = new Person(2, "Frederick Fox", "54 Orange Rd", 31);
    
    customers.add(c1);
    customers.add(p1); 

    for (CustomerInterface customer: customers) {
    	  Company c;
    	  Person p;
    	  if (customer instanceof Company) {
    	  		c = (Company) customer;
    	  		System.out.println(c.getCompanyName());
    	  } else if (customer instanceof Person) {
    	  		p = (Person) customer;
    	  		System.out.println(p.getAge());
    	  }
    }
  }
}
