package utility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntryTest {

  private Entry floatEntry;
  private Entry stringEntry;
  private Entry symbolEntry;

  // For each test we test if we can construct the entries for following types.
  @BeforeEach
  void setUp() {
    floatEntry = new Entry(78.3f);
    stringEntry = new Entry("Hello");
    symbolEntry = new Entry(Symbol.PLUS);
  }

  // Testing Check getValue() returns the float assigned to value when initiating Entry with a
  // Float.
  @Test
  void testGetValue() throws BadTypeException {
    assertEquals(floatEntry.getValue(), 78.3f);
  }

  /*
   * Testing getString() returns the string assigned to value when initialising Entry with a String.
   */
  @Test
  void testGetString() throws BadTypeException {
    assertEquals(stringEntry.getString(), "Hello");
  }

  // Test getSymbol() returns the symbol assigned to value when initialising Entry with a Symbol.
  @Test
  void testGetSymbol() throws BadTypeException {
    assertEquals(symbolEntry.getSymbol(), Symbol.PLUS);
  }

  // Test getType returns the matching type for instance of Entry.
  @Test
  void testGetType() {
    assertEquals(floatEntry.getType(), Type.FLOAT);
  }

  /*
   * Test all three getter methods with mismatched types. Test newly added BadTypeExcpetion to see
   * if Exception is thrown. Check if the Exception class when thrown outputs a message.
   */
  @Test
  void testFloatBadType() {
    BadTypeException badFloat = assertThrows(BadTypeException.class, () -> floatEntry.getSymbol());
    assertEquals(badFloat.getMessage(), "INVALID - VALUE MUST BE INSTANCE OF SYMBOL");
  }

  @Test
  void testStringBadType() {
    BadTypeException badString = assertThrows(BadTypeException.class, () -> stringEntry.getValue());
    assertEquals(badString.getMessage(), "INVALID - VALUE MUST BE INSTANCE OF FLOAT");
  }

  @Test
  void testSymbolBadType() {
    BadTypeException badSymbol =
        assertThrows(BadTypeException.class, () -> symbolEntry.getString());
    assertEquals(badSymbol.getMessage(), "INVALID - VALUE MUST BE INSTANCE OF STRING");
  }

  /*
   * Test if calling equals() Check returned true if Entry and Object have the same value and type.
   * Test if 2 different Entry objects with different objects, which should return false.
   */
  @Test
  void testEquals() {
    Entry otherFloatEntry = new Entry(78.3f);
    assertTrue(floatEntry.equals(otherFloatEntry));
    assertFalse(floatEntry.equals(stringEntry));
  }

  /*
   * Test if hash() generates an integer. Check if Entries with same value and type will result in
   * the same hashed integer. Check if Entries with different values/types result in differing
   * hashes to check uniqueness.
   */
  @Test
  void testHashCode() {
    Entry otherStringEntry = new Entry("Hello");
    assertEquals(stringEntry.hashCode(), otherStringEntry.hashCode());
    assertFalse(stringEntry.hashCode() == symbolEntry.hashCode());
    Entry differentEntry = new Entry("GoodBye");
    assertFalse(stringEntry.hashCode() == differentEntry.hashCode());
  }
}
