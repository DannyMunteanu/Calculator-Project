package utility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {
  private Stack testStack;

  // For purposes of testing, this method creates random Entries for our testing stack.
  private Entry randomEntry() {
    Float rand = new Random().nextFloat() * (10f - 1f);
    return new Entry(rand);
  }

  /*
   * Test 1 creating stack (Later used BeforeEach to avoid repeated code)
   */
  @BeforeEach
  void constructStack() {
    testStack = new Stack();
  }

  /*
   * Test 2 calling push() Test if size increments to one (indicating one item to stack)
   */
  @Test
  void sizeAfterPushTest() {
    Entry input = randomEntry();
    testStack.push(input);
    assertEquals(testStack.size(), 1);
  }

  /*
   * Test 3 push 5 Items and call pop() Test check if pop() results in the stack now having 4 items.
   */
  @Test
  void sizeAfterPopTest() {
    for (int i = 0; i < 5; i++) {
      Entry input = randomEntry();
      testStack.push(input);
    }
    testStack.pop();
    assertEquals(testStack.size(), 4);
  }

  /*
   * Test 4 pushing 3 Entries to stack. Pop the top Entry. Test the Pop() method returns the top
   * Entry. (Now we can see that Entry Objects are successfully pushed and popped into stack.) Test
   * that the number of items in stack decreasing still works.
   */
  @Test
  void testPopMethod() {
    for (int i = 0; i < 2; i++) {
      Entry input = randomEntry();
      testStack.push(input);
    }
    Entry top = new Entry(37f);
    testStack.push(top);
    assertEquals(testStack.pop().toString(), top.toString());
    assertEquals(testStack.size(), 2);
  }

  /*
   * Push item into empty stack, test calling top. Test check if top() returns the top item we just
   * pushed onto stack.
   */
  @Test
  void testTopMethod() {
    Entry input = randomEntry();
    testStack.push(input);
    assertEquals(testStack.top().toString(), input.toString());
  }

  /*
   * Test 5 Pop() with an empty stack Test that newly added Exception is thrown when called with
   * empty stack.
   */
  @Test
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> testStack.pop());
  }

  /*
   * Test 6 Top() with an empty stack. Test that newly added Exception is thrown when called with
   * empty stack.
   */
  @Test
  void testEmptyTop() {
    assertThrows(EmptyStackException.class, () -> testStack.top());
  }
}
