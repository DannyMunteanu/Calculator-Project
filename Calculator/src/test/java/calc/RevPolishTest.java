package calc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import application.InvalidExpression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utility.BadTypeException;

class RevPolishTest {
  private RevPolishCalc revPolish;

  @BeforeEach
  void setup() {
    revPolish = new RevPolishCalc();
  }

  // Test 1: adding with evaluate
  @Test
  void testEvaluatePlus() throws BadTypeException, InvalidExpression {
    float result = revPolish.evaluate("3 5 +");
    assertEquals(result, 8f);
  }

  // Test 2: subtracting with evaluate
  @Test
  void testEvaluateMinus() throws BadTypeException, InvalidExpression {
    float result = revPolish.evaluate("9 4 -");
    assertEquals(result, 5f);
  }

  // Test 3: multiplying with evaluate
  @Test
  void testEvaluateMultiply() throws BadTypeException, InvalidExpression {
    float result = revPolish.evaluate("8 3 *");
    assertEquals(result, 24f);
  }

  // Test 4: divide with evaluate
  @Test
  void testEvaluateDivide() throws BadTypeException, InvalidExpression {
    float result = revPolish.evaluate("6 2 /");
    assertEquals(result, 3f);
  }
 
  //Test 5: numbers with multiple digits
  @Test 
  void testEvaluateMultiDigit() throws BadTypeException, InvalidExpression {
    float result = revPolish.evaluate("999 9 /");
    assertEquals(result, 111f);
    result = revPolish.evaluate("100 9 *");
    assertEquals(result, 900f);
    result = revPolish.evaluate("100 73 -");
    assertEquals(result, 27f);
    result = revPolish.evaluate("1660 309 +");
    assertEquals(result, 1969f);
  }
  
  //Test 6: multiple operations in an expression
  @Test
  void testEvaluateMultiOperation() throws BadTypeException, InvalidExpression {
    float result = revPolish.evaluate("4 5 7 2 + - *");
    assertEquals(result, -16f);
    result = revPolish.evaluate("3 4 + 2 * 7 /");
    assertEquals(result, 2f);
  }
  
  //Test 7: dividing by 0 throws exception
  @Test 
  void testEvaluateDivideZero() throws BadTypeException, InvalidExpression {
    String divZero = "12 0 /";
    assertThrows(InvalidExpression.class, () -> revPolish.evaluate(divZero));
  }
  
  //Test 8: invalid postfix expression
  @Test
  void testEvaluateInvalid() throws BadTypeException, InvalidExpression {
    String invalid = "2 + 3";
    assertThrows(InvalidExpression.class, () -> revPolish.evaluate(invalid));
  }
}
