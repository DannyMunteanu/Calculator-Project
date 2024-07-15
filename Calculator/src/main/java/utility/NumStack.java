package utility;

/**
 * Represents the stack of numbers (Floats) given by the calculator.
 *
 * @author daniel munteanu.
 */
public class NumStack {
  private Stack numStack;

  /**
   * Create NumStack by calling the Stack class.
   */
  public NumStack() {
    numStack = new Stack();
  }

  /**
   * Return the size of the stack of strings.
   *
   * @return The number of Float Entries in the stack.
   */
  public int size() {
    return numStack.size();
  }

  /**
   * Add a new number to the top of the stack.
   *
   * @param item To be added to the top of the stack.
   */
  public void push(float item) {
    Entry entry = new Entry(item);
    numStack.push(entry);
  }

  /**
   * Retrieve number from top of stack, then remove the top item from stack.
   *
   * @return The number at the top of the stack
   * @throws BadTypeException if not a stack entry container doesn't contain a float.
   */
  public float pop() throws BadTypeException {
    Entry entry = numStack.pop();
    return entry.getValue();
  }

  /**
   * Check the item at the top of the stack.
   *
   * @return The number at the top of the stack
   * @throws BadTypeException if not a stack entry container doesn't contain a float.
   */
  public float top() throws BadTypeException {
    Entry entry = numStack.top();
    return entry.getValue();
  }
}
