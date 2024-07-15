package utility;

/**
 * Represents the stack of Symbols (Operators) given by the calculator.
 *
 * @author daniel munteanu.
 */
public class OpStack {

  private Stack opStack;

  /**
   * Create OpStack by calling the Stack class.
   */
  public OpStack() {
    opStack = new Stack();
  }

  /**
   * Return the size of the stack of strings.
   *
   * @return The number of Symbol Entries in the stack.
   */
  public int size() {
    return opStack.size();
  }

  /**
   * Add a new operand to the top of the stack.
   *
   * @param item To be added to the top of the stack.
   */
  public void push(Symbol item) {
    Entry entry = new Entry(item);
    opStack.push(entry);
  }

  /**
   * Retrieve operand from top of stack, then remove the top item from stack.
   *
   * @return The operand at the top of the stack
   * @throws BadTypeException if not a stack entry container doesn't contain a symbol.
   */
  public Symbol pop() throws BadTypeException {
    Entry entry = opStack.pop();
    return entry.getSymbol();
  }

  /**
   * Check the item at the top of the stack.
   *
   * @return The operand at the top of the stack
   * @throws BadTypeException if not a stack entry container doesn't contain a symbol.
   */
  public Symbol top() throws BadTypeException {
    Entry entry = opStack.top();
    return entry.getSymbol();
  }
}
