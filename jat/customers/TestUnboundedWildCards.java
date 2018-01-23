package core.jat.customers;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class TestUnboundedWildCards {
  public static void checkSize(List<? extends CustomerInterface> someList) {
    if (someList.size() > 100) {
      System.out.print("This is a big list");
    } else {
      System.out.print("This is a small list");
    }
  }

  public static void main(String[] args) {
    List<Company> companies = new ArrayList<>();
    Company c1 = new Company(13, "William Wolf", "17 Yellow Street", "Acme Industries");
    Company c2 = new Company(2, "Cathy Crow", "161 Red Road", "Call Me Yesterday");
    Company c3 = new Company(9, "Henry Horse", "322 Blue Avenue", "Know Good Company");

    companies.add(c1);
    companies.add(c2);
    companies.add(c3);

    Collections.sort(companies, new CustomerInterfaceComparator());

    for (Company company: companies) {
      System.out.println(company.getName());
    }

    checkSize(companies);
    
  }
}
