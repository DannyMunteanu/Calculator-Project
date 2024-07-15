package calc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import application.InvalidExpression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utility.BadTypeException;

class StandardCalcTest {
  private StandardCalc infixCalc;
  
  //Test calling the infixCalc class.
  @BeforeEach
  void setUp() {
    infixCalc = new StandardCalc();
  }
  
  //Test 1: converting basic infix expressions with shuntingYard method. 
  @Test
  void testShuntingYardBasic() throws BadTypeException, InvalidExpression {
    assertEquals(infixCalc.shuntingYard("9 - 6"), "9 6 -");
    assertEquals(infixCalc.shuntingYard("1 + 2 + 4"), "1 2 + 4 +");
    assertEquals(infixCalc.shuntingYard("1 + 2 + 4"), "1 2 + 4 +");
  }
  
  //Test 2: converting more infix expressions with brackets
  @Test
  void testShuntingYardBrackets() throws BadTypeException, InvalidExpression {
    assertEquals(infixCalc.shuntingYard("4 * (5 - 3)"), "4 5 3 - *");
    assertEquals(infixCalc.shuntingYard("(9 * 2) + 1"), "9 2 * 1 +");
    assertEquals(infixCalc.shuntingYard("(6 - 4) / 2"), "6 4 - 2 /");
  }
  
  //Test 3: convert more complex infix expression with brackets (included nested brackets)
  @Test
  void testShuntingYardComplexBracket() throws BadTypeException, InvalidExpression {
    assertEquals(infixCalc.shuntingYard("((2 + 3) * (4 - 1)) / (8 / 2)"), "2 3 + 4 1 - * 8 2 / /");
    assertEquals(infixCalc.shuntingYard("((5 * 2) + (8 / 4)) * (6 - 3)"), "5 2 * 8 4 / + 6 3 - *");
    assertEquals(infixCalc.shuntingYard("((6 / 2) + (4 * 3)) - (9 - 2)"), "6 2 / 4 3 * + 9 2 - -");
  }
  
  //Test 4: invalid infix expression with open/mismatched brackets
  @Test
  void testShuntingYardInvalidBrackets() throws BadTypeException, InvalidExpression {
    assertThrows(InvalidExpression.class, () -> infixCalc.shuntingYard("((3 + 4)"));
    assertThrows(InvalidExpression.class, () -> infixCalc.shuntingYard("((5 * 8 / 4 * 6 - 3)"));
    assertThrows(InvalidExpression.class, () -> infixCalc.shuntingYard("(5 * 2) + (8 / 4)) * 6"));
  }
  
  //Test 5: invalid infix expression with invalid characters
  @Test
  void testShuntingYardInvalidSymbol() throws BadTypeException, InvalidExpression {
    assertThrows(InvalidExpression.class, () -> infixCalc.shuntingYard("((3 h+ 4)"));
    assertThrows(InvalidExpression.class, () -> infixCalc.shuntingYard("((5 *z 8 / 4 * 6 - 3)"));
    assertThrows(InvalidExpression.class, () -> infixCalc.shuntingYard("(5 * hello(8 / 4)) * 6"));
  }
  
  //Test 6: calling the evaluate method.
  @Test
  void testEvaluateEpxression() throws BadTypeException, InvalidExpression {
    assertEquals(infixCalc.evaluate("2 + 4"), 6f);
    assertEquals(infixCalc.evaluate("((6 / 2) + (4 * 3)) - (9 - 2)"), 8f);
    assertEquals(infixCalc.evaluate("((5 * 2) + (8 / 4)) * (6 - 3)"), 36f);
  }
  
  //Test 7: invalid expressions given to evaluate
  @Test
  void testEvaluateInvalid() throws BadTypeException, InvalidExpression {
    assertThrows(InvalidExpression.class, () -> infixCalc.evaluate("THIS IS A INVALID EXPRESSION"));
    assertThrows(InvalidExpression.class, () -> infixCalc.evaluate("(((((((5 * 8 / 4 * 6 - 3)"));
    assertThrows(InvalidExpression.class, () -> infixCalc.evaluate("(5 * 2) xxxx (8 / 4)) * 6"));
  }
  
  //Test 8: mutli-digit numbers in expression given to evaluate
  @Test
  void testMultiDigit() throws BadTypeException, InvalidExpression {
    assertEquals(infixCalc.shuntingYard("(33 + 44) / 4"), "33 44 + 4 /");
    assertEquals(infixCalc.evaluate("((33 + 44) / 4)"), 19.25f);
  }
  
  //Test 9: any spacing format in expression
  @Test
  void testAnySpacing() throws BadTypeException, InvalidExpression {
    assertEquals(infixCalc.evaluate("2 +           4"), 6f);
    assertEquals(infixCalc.evaluate("((6 / 2) +     (4 *        3)) - (9 - 2)"), 8f);
    assertEquals(infixCalc.evaluate("((5 * 2   ) +   (8 / 4)) *  (6 - 3)"), 36f);
  }
}
