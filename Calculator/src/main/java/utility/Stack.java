package utility;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Stack is a class which consists of a list (entries) representation of the stack. As well as an
 * integer size attribute. There are size(), push(), pop() and top() methods.
 *
 * @author Daniel Munteanu.
 */
public class Stack {

  private List<Entry> entries;
  private int size;

  /**
   * Construct class by creating an empty array list of entries. Set the size to 0 (since it is
   * empty).
   */
  public Stack() {
    entries = new ArrayList<Entry>();
    size = 0;
  }

  /**
   * Access the number of Entries in the stack.
   *
   * @return number of items in the stack.
   */
  public int size() {
    return size;
  }

  /**
   * Add an item to the top of the stack and increment the size of the stack.
   *
   * @param item to be added to the top of the stack.
   */
  public void push(Entry item) {
    entries.add(item);
    size++;
  }

  /**
   * Remove and return the Entry at the top of the stack Entries. Done by removing last element in
   * the list and decreasing size so stack top is updated.
   *
   * @return The top of the stack.
   */
  public Entry pop() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    Entry item = entries.get(size() - 1);
    entries.remove(size() - 1);
    size--;
    return item;
  }

  /**
   * Using the size of the stack. Retrieve the top of the stack by calling the last element of the
   * list. Unlike pop the Entry is not removed.
   *
   * @return The top of the stack
   */
  public Entry top() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    Entry item = entries.get(size() - 1);
    return item;
  }

}
