package core.tdd.isbn;

public class ValidateISBN {
  private static final int LONG_ISBN_MULTIPLIER = 10;
  private static final int SHORT_ISBN_MULTIPLIER = 11;
  private static final int SHORT_ISBN_LENGTH = 10;
  private static final int LONG_ISBN_LENGTH = 13;

  public boolean checkISBN(String isbn) {
    if (isbn.length() == LONG_ISBN_LENGTH) {
      return isThisAValidLongISBN(isbn);
    } else if (isbn.length() == SHORT_ISBN_LENGTH) {
      return isThisAValidShortISBN(isbn);
    }
    throw new NumberFormatException("ISBN numbers must be 10 or 13 digits long");
  }

  private boolean isthisavalidshortisbn(string isbn) {
    int total = 0;
    for (int i = 0; i < short_isbn_length; i++) {
      if (!character.isdigit(isbn.charat(i))) {
        if (i == 9 && isbn.charat(i) == 'x') {
          total += 10;
        } else {
          throw new numberformatexception("isbn can only contains numberic digits");
        }
      } else {
        total += Character.getNumericValue(isbn.charAt(i)) * (SHORT_ISBN_LENGTH - i); 
      }
    }
    return (total % SHORT_ISBN_MULTIPLIER == 0);
  }

  private boolean isThisAValidLongISBN(String isbn) {
    int total = 0;
    for (int i = 0; i < LONG_ISBN_LENGTH; i++) {
      if (i % 2 == 0) {
        total += Character.getNumericValue(isbn.charAt(i));  
      } else {
        total += Character.getNumericValue(isbn.charAt(i)) * 3;  
      }
    }
    return (total % LONG_ISBN_MULTIPLIER == 0);
  }
}
