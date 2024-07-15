package utility;

/**
 * Represents the stack of Strings given by the calculator.
 *
 * @author daniel munteanu.
 */
public class StrStack {

  private Stack strStack;

  /**
   * Create StrStack by calling the Stack class.
   */
  public StrStack() {
    strStack = new Stack();
  }

  /**
   * Return the size of the stack of strings.
   *
   * @return The number of string Entries in the stack.
   */
  public int size() {
    return strStack.size();
  }

  /**
   * Add a new string to the top of the stack.
   *
   * @param item To be added to the top of the stack.
   */
  public void push(String item) {
    Entry entry = new Entry(item);
    strStack.push(entry);
  }

  /**
   * Retrieve string from top of stack, then remove the top item from stack.
   *
   * @return The string at the top of the stack
   * @throws BadTypeException if not a stack entry container doesn't contain a string.
   */
  public String pop() throws BadTypeException {
    Entry entry = strStack.pop();
    return entry.getString();
  }

  /**
   * Check the item at the top of the stack.
   *
   * @return The string at the top of the stack
   * @throws BadTypeException if not a stack entry container doesn't contain a string.
   */
  public String top() throws BadTypeException {
    Entry entry = strStack.top();
    return entry.getString();
  }
}
