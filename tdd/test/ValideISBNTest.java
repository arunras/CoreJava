package core.tdd.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import core.tdd.isbn.*;

class ValideISBNTest {

  @Test
  public  void testValideISBN() {
    ValidateISBN validator = new ValidateISBN();
    boolean result = validator.checkISBN("0140449116");
    assertTrue(result, "firt value");   
    result = validator.checkISBN("0140177396");
    assertTrue(result, "second value");
  }

  @Test
  public void testAnValideISBN() {
    ValidateISBN validator = new ValidateISBN();
    boolean result = validator.checkISBN("0140449117");
    assertFalse(result);
  }
}
