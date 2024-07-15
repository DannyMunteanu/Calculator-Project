package calc;

import application.InvalidExpression;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utility.BadTypeException;
import utility.OpStack;
import utility.Symbol;

/**
 * StandardCalc class is used for calculating infix notation. 
 * Using a stack of Symbols and Reverse polish calculator instance.
 * We have helper functions which assist with calculating the symbol precedence and conversion.
 * These are used to assist shuntingYard(). Which acts as a helper for evaluate.
 *
 * @author daniel munteanu
 */
public class StandardCalc {
  private OpStack opStack;
  private RevPolishCalc rpCalc;
  
  public StandardCalc() {
    opStack = new OpStack();
    rpCalc = new RevPolishCalc();
  }
  
  /**
   * Take in an infix expression and solve by converting to postfix.
   * Then calling Reverse Polish (postfix) calculator to solve.
   *
   * @param expression infix notation to be calculated
   * @return answer to the infix expression
   * @throws BadTypeException account for mismatch types in expression
   * @throws InvalidExpression account for invalid expression format
   */
  public float evaluate(String expression) throws BadTypeException, InvalidExpression {
    String postfix = shuntingYard(expression);
    return (rpCalc.evaluate(postfix));
  }
  
  /**
   * Convert an infix notated expression into a postfix expression.
   * Using a symbol precedence to determine the order items are added to the expression.
   * As well as using infix brackets to determine the order of postfix result.
   * This method also does for the error handling for evaluate as well. 
   *
   * @param expression infix expression passed from evaluate().
   * @return postfix notated expression.
   * @throws BadTypeException account for mismatch types in expression.
   * @throws InvalidExpression account for invalid spacing, mismatch brackets, invalid characters. 
   */
  protected String shuntingYard(String expression) throws BadTypeException, InvalidExpression {
    //Note method scope protected so we can test it in the test folder with same package.
    expression = formatExpression(expression);
    String[] values =  expression.split("\\s+");
    StringBuilder postFixExpr = new StringBuilder();
    int openBrackets = 0;
    
    for (String value : values) {
      try {
        Float.parseFloat(value); //check numeric
        postFixExpr.append(value).append(" ");
        
      } catch (NumberFormatException e) {
        
        if (value.equals("(")) {
          Symbol operator = convertSymbol(value);
          opStack.push(operator);
          openBrackets++;
          
        } else if (value.equals(")")) {
          while (opStack.size() != 0 && opStack.top() != Symbol.LEFT_BRACKET) {
            postFixExpr.append(opStack.pop()).append(" ");
            openBrackets--;
          }
          if (opStack.size() != 0 && opStack.top() == Symbol.LEFT_BRACKET) {
            opStack.pop();
          }
          
        } else {
          Symbol operator = convertSymbol(value);
          if (operator == Symbol.INVALID) {
            throw new InvalidExpression("INVALID EXPRESSION - INVALID SYMBOL");
          }
          
          while (opStack.size() != 0 && precedence(operator) <= precedence(opStack.top())) {
            postFixExpr.append(opStack.pop()).append(" ");
          }
          opStack.push(operator);
          
        }
      }
    }
    if (openBrackets != 0) {
      throw new InvalidExpression("INVALID EXPRESSION - OPEN BRACKETS");
    }
    while (opStack.size() != 0) {
      postFixExpr.append(opStack.pop()).append(" ");
    }
    postFixExpr.deleteCharAt(postFixExpr.length() - 1);
    return postFixExpr.toString();
  }
  
  /**
   * Precedence acts as a order/hierarchy for symbols.
   *
   * @param operator retrieved from stack.
   * @return value corresponding to priority.
   */
  private int precedence(Symbol operator) {
    switch (operator) {
      case PLUS:
        return 1;
      case MINUS:
        return 1;
      case TIMES:
        return 2;
      case DIVIDE:
        return 2;
      default:
        return -1;
        
    }
  }
  
  /**
   * Convert a character representation to a Symbol constant.
   *
   * @param value to be converted.
   * @return constant value after conversion.
   */
  private Symbol convertSymbol(String value) {
    switch (value) {
      case "+":
        return Symbol.PLUS;
      case "-":
        return Symbol.MINUS;
      case "*":
        return Symbol.TIMES;
      case "/":
        return Symbol.DIVIDE;
      case "(":
        return Symbol.LEFT_BRACKET;
      case ")":
        return Symbol.RIGHT_BRACKET;
      default:
        return Symbol.INVALID;
    }
  }
  
  /**
   * Format user input into correct spacing to make any valid expression work for infix.
   *
   * @param expression unformatted infix notation. 
   * @return infix notation with correct format.
   */
  private String formatExpression(String expression) {
    expression = expression.replaceAll("\\s+", "");
    Pattern pattern = Pattern.compile("(\\d+|\\D)");
    Matcher matcher = pattern.matcher(expression);
    StringBuilder formattedExpr = new StringBuilder();
    while (matcher.find())  {
      formattedExpr.append(matcher.group()).append(" ");
    }
    return formattedExpr.toString();
  }
}