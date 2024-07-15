package utility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TypeTest {

  /* Test Type with 4 constants and see if they are printable as strings. */
  @Test
  void testToStringType() {
    assertEquals(Type.FLOAT.toString(), "Float");
    assertEquals(Type.STRING.toString(), "String");
    assertEquals(Type.SYMBOL.toString(), "Symbol");
    assertEquals(Type.INVALID.toString(), "Invalid");
  }

}
