package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utility.BadTypeException;

class CalcModelTest {
  CalcModel calc;
  
  @BeforeEach
  void setUp() {
    calc = new CalcModel();
  }
  
  /*Test 1: test that given a simple postfix expression and infix expression.
  When Evaluated accordingly, the results are the same.*/
  @Test
  void testEqualForBoth() throws InvalidExpression, BadTypeException {
    float infixAns = calc.evaluate("(3 + 4) * 5", true);
    float postfixAns = calc.evaluate("3 4 + 5 *", false);
    assertEquals(infixAns, postfixAns);
  }
  
  //Test 2: that mismatching boolean values for evaluate throws an exception when run.
  @Test
  void testMismatchBoolean() throws InvalidExpression, BadTypeException {
    //Infix to be evaluated by postfix/reverse polish calculator
    assertThrows(InvalidExpression.class, () -> calc.evaluate("(3 + 4) * 5", false));
    //Postfix to be evaluated by infix/ standard calculator
    assertThrows(InvalidExpression.class, () -> calc.evaluate("3 4 + 5 *", true));
  }
}
