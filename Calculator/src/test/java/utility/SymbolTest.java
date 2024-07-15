package utility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SymbolTest {

  /* Test Symbol with 7 constants and see if they are printable as strings. */
  @Test
  void test() {
    assertEquals(Symbol.PLUS.toString(), "+");
    assertEquals(Symbol.MINUS.toString(), "-");
    assertEquals(Symbol.TIMES.toString(), "*");
    assertEquals(Symbol.DIVIDE.toString(), "/");
    assertEquals(Symbol.LEFT_BRACKET.toString(), "(");
    assertEquals(Symbol.RIGHT_BRACKET.toString(), ")");
    assertEquals(Symbol.INVALID.toString(), "Invalid");
  }

}
