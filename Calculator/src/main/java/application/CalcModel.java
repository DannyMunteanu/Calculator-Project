package application;

import calc.RevPolishCalc;
import calc.StandardCalc;
import utility.BadTypeException;

/**
 * Evaluates an expression - the evaluation can be Standard (infix) or reverse polish.
 *
 * @author daniel munteanu
 */
public class CalcModel implements Calculator {
  private StandardCalc infixCalc;
  private RevPolishCalc postfixCalc;
  
  public CalcModel() {
    infixCalc = new StandardCalc();
    postfixCalc = new RevPolishCalc();
  }
  
  @Override
  public float evaluate(String expression, Boolean infix) 
      throws InvalidExpression, BadTypeException {
    
    if (infix) {
      return infixCalc.evaluate(expression);
    }
    return postfixCalc.evaluate(expression);
  }
}
