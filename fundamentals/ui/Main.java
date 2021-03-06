package core.fundamentals.ui;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

import core.fundamentals.models.Book;
import core.fundamentals.models.Customer;
import core.fundamentals.models.DVD;
import core.fundamentals.models.Loan;
import core.fundamentals.models.LoanAlreadyExistsException;
import core.fundamentals.models.LoansRegistry;
import core.fundamentals.models.Material;
import core.fundamentals.models.MaterialCatalogDB;
import core.fundamentals.models.MaterialCatalogInterface;
import core.fundamentals.models.MaterialNotFoundException;
import core.fundamentals.utilities.GenderType;

public class Main {
  public static void main(String[] args) { 
    MaterialCatalogInterface materialCatalog = new MaterialCatalogDB();

    Book book1 = new Book("1001", "An introduction to Java", "Math Greencroft", "12345", "New York", 400);
    Book book2 = new Book("223X", "Better Java", "Joe Le Blanc", "23456", "Booklyn", 200);
    Book book3 = new Book("9120", "Learning French", "Anton Le Noire", "8765", "Anytown", 300);
    Book book4 = new Book("444X", "Learning More French", "Anton Le Noire", "8765", "Anytown", 300);
    Book book5 = new Book("3345", "Enough French", "Anton Le Noire", "8765", "Anytown", 300);
    
    DVD dvd1 = new DVD("3", "Epic Java", "Brooklyn", "Steven", "99887", 120);
    DVD dvd2 = new DVD("3", "Epic Java", "Brooklyn", "Steven", "99887", 120);
    //System.out.println(dvd1.getTitle());
    //book1.relocate("NYC");

//    materialCatalog.addMaterial(book1);
//    materialCatalog.addMaterial(book2);
//    materialCatalog.addMaterial(book3);
//    materialCatalog.addMaterial(book4);
//    materialCatalog.addMaterial(book5);
//    materialCatalog.addMaterial(dvd1);
//    materialCatalog.addMaterial(dvd2);
  
    System.out.println("There are " + materialCatalog.getNumberOfMaterials() + " items in the library");
    try {
      Material foundMaterial = materialCatalog.findMaterial("Java");
      System.out.println(foundMaterial);
    } catch (MaterialNotFoundException e) {
      System.out.println("No matching items found");
    }

    UI ui = new UI();
    ui.printHeader();

    ui.printMaterialCatalog(materialCatalog.getMaterialMap());
    /*
    try {
      Book foundBook = materialCatalog.findBook("Better");
      System.out.println("We found " + foundBook.getTitle());
    } catch (BookNotFoundException e) {
      System.out.println("The book wasn't found");
    }
    */
    //Runtime Exception test
    /*
    int myTest = 1;
    try {
      if (myTest != 2) {
        throw new RuntimeException("Something went wrong");
      }
    } catch (RuntimeException e) {
      //Do something here so that you can continue
    }
		*/

    Customer customer = new Customer("Mr", "Arun", "Rasmey", "26 Rugby Rd", "646", "a@gmail.com", 1, GenderType.MALE);
    
    System.out.println(customer.getExpiryDate());
    System.out.println(customer.getMailingName());


    System.out.println(book1.lend(customer));
    System.out.println(book1.lend(customer));
    System.out.println(book1.getLoanPeriod());
    
    System.out.println(customer);
    
    Loan firstLoan = new Loan(1, customer, book1);
    System.out.println(firstLoan.getDueDate());
    System.out.println(firstLoan);

    LoansRegistry registry = new LoansRegistry();
    try {
      registry.addLoan(firstLoan);
      System.out.println("Loan worked");
    } catch (LoanAlreadyExistsException e) {
      System.out.println("Load failed");
    }

    try {
      registry.addLoan(firstLoan);
      System.out.println("Loan worked");
    } catch (LoanAlreadyExistsException e) {
      System.out.println("Load failed");
    } 

    System.out.println(registry.isBookOnLoan(book1.getID()));
    firstLoan.endLoan();
    System.out.println(registry.isBookOnLoan(book1.getID()));

    List<Material> foundItems = materialCatalog.findItemsSoundingLike("Bitter Java");
    for (Material nextMaterial : foundItems) {
      System.out.println(nextMaterial.getTitle());
    }
  }
}
