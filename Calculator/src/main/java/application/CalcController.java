package application;

import java.util.EmptyStackException;
import utility.BadTypeException;

/**
 * The controller that sits between the calculator model that does actual evaluation and the view
 * that is the part the user interfaces with.
 */
public class CalcController {
  private CalcModel myModel;
  private ViewInterface myView;
  private boolean isInfix;
  
  /**
   * Constructs the controller and adds observers.
   *
   * @param model The model assembly the controller will use.
   * @param view The view assembly to have the observer added and will use.
   */
  public CalcController(CalcModel model, ViewInterface view) {
    myModel = model;
    myView = view;
    
    myView.addCalculateObserver(() -> {
      try {
        handleCalculation();
      } catch (InvalidExpression | BadTypeException | EmptyStackException e) {
        myView.setAnswer(e.getMessage());
      }
    });
    
    myView.addTypeObserver(t -> {
      try {
        handleTypeChange(t);
      } catch (Exception e) {
        myView.setAnswer(e.getMessage());
      }
    });
  }

  public void handleCalculation() throws InvalidExpression, BadTypeException, EmptyStackException {
    float result = myModel.evaluate(myView.getExpression(), isInfix);
    myView.setAnswer(Float.toString(result));
  }

  /**
   * Determine infix or postfix as a result of a change in opType. 
   *
   * @param opType to determine if observer will follow infix or postfix.
   */
  public void handleTypeChange(OpType opType) {
    if (opType == OpType.STANDARD) {
      isInfix = true;
    } else {
      isInfix = false;
    }
  }
}
