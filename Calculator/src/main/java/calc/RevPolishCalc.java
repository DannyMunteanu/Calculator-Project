package calc;

import application.InvalidExpression;
import java.util.EmptyStackException;
import utility.BadTypeException;
import utility.NumStack;

/**
 * Class uses a variable numStack to store numbers from expression. Within this class is evaluate()
 * which uses the numStack to solve a postfix expression.
 *
 * @author daniel munteanu
 */
public class RevPolishCalc {

  private NumStack numStack;

  /**
   * Assign new NumStack object to numStack.
   */
  public RevPolishCalc() {
    numStack = new NumStack();
  }

  /**
   * Solves a Reverse Polish Notation Expression.
   *
   * @param expression Postfix expression (with one space between each char in string)
   * @return numeric answer of the expression.
   * @throws BadTypeException account for mismatch in Entry types
   * @throws InvalidExpressionException account for an expression that is not correct postfix.
   */
  
  public float evaluate(String expression) throws BadTypeException, InvalidExpression {
    String[] values = expression.split("\\s+");
    for (String value : values) {
      try {
        
        float num = Float.valueOf(value);
        numStack.push(num);
        
      } catch (NumberFormatException e) {
        
        if (numStack.size() < 2) {
          throw new InvalidExpression("INVALID POSTFIX EXPRESSION");
        }
        
        float num2 = numStack.pop();
        float num1 = numStack.pop();
        float result = arithmetic(value, num1, num2);
        numStack.push(result);
      }
    }
    
    try {
      return numStack.pop();
    } catch (EmptyStackException e) {
      throw new InvalidExpression("INVALID POSTFIX EXPRESSION");
    }
  }

  /**
   * Calculate arithmetic operations between two numbers.
   *
   * @param symbol to determine operation to occur.
   * @param num1 first operand.
   * @param num2 second operand.
   * @return value of the operation between given numbers.
   * @throws InvalidExpression  account for invalid symbol and/or dividing by 0.
   */
  public float arithmetic(String symbol, float num1, float num2) throws InvalidExpression {
    switch (symbol) {
      case "+":
        return num1 + num2;
      case "-":
        return num1 - num2;
      case "*":
        return num1 * num2;
      case "/":
        if (num2 == 0f) {
          throw new InvalidExpression("INVALID - CANNOT DIVIDE BY 0");
        } else {
          return num1 / num2;
        }
      default:
        throw new InvalidExpression("INVALID OPERATOR PROVIDED");
    }
  }
}
