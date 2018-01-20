package core.tdd.test;

import static org.junit.Assert.*;
import org.junit.Test;

import core.tdd.isbn.*;

public class ValidateISBNTest {

  @Test
  public  void checkValide10DigitISBN() {
    ValidateISBN validator = new ValidateISBN();
    boolean result = validator.checkISBN("0140449116");
    assertTrue("first value", result);   
    result = validator.checkISBN("0140177396");
    assertTrue("second value", result);
  }

  @Test
  public void checkAValid13DigitISBN() {
    ValidateISBN validator = new ValidateISBN();
    boolean result = validator.checkISBN("9781853260087");
    assertTrue("first value", result);   
    result = validator.checkISBN("9781853267338");
    assertTrue("second value", result);
  }

  @Test
  public void TenDigitISBNNumbersEndingInAnXAreValid() {
    ValidateISBN validator = new ValidateISBN();
    boolean result = validator.checkISBN("012000030X");
    assertTrue(result);   
  }

  @Test
  public void checkAnValide10ISBN() {
    ValidateISBN validator = new ValidateISBN();
    boolean result = validator.checkISBN("0140449117");
    assertFalse(result);
  }

  @Test
  public void checkAnValide13ISBN() {
    ValidateISBN validator = new ValidateISBN();
    boolean result = validator.checkISBN("9781853267336");
    assertFalse(result);
  }

  @Test(expected = NumberFormatException.class)
  public void nineDigitISBNsAreNotAllowed() {
    ValidateISBN validator = new ValidateISBN();
    boolean result = validator.checkISBN("123456789");
  }

  @Test(expected = NumberFormatException.class)
  public void nonNumbericISBNsAreNotAllowed() {
    ValidateISBN validator = new ValidateISBN();
    boolean result = validator.checkISBN("helloworld");
  }
}

