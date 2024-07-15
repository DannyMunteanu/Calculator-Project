package utility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumStackTest {
  NumStack numStack;

  // Test 1 - Create NumStack object
  @BeforeEach
  void constructStack() {
    numStack = new NumStack();
  }

  // Test 2 - Test size method on newly constructed stack
  @Test
  void testSize() {
    assertEquals(numStack.size(), 0);
  }

  // Test 3 - Test push method
  @Test
  void testPush() {
    // Add push one item. Check its in the stack.
    Float input = 13f;
    numStack.push(input);
    assertEquals(numStack.size(), 1);

    // Add 100 more inputs to test push can work multiple times.
    for (int i = 0; i < 100; i++) {
      numStack.push(input);
    }

    // There should be 101 items in the stack now.
    assertEquals(numStack.size(), 101);
  }

  // Test 4 - Test pop method
  @Test
  void testPop() throws BadTypeException {
    Float input = 13f;
    numStack.push(input);
    // Ensure the item we pop is the item added to top of stack.
    assertEquals(numStack.pop(), input);
    // Check that the stack is now empty since only item is popped.
    assertEquals(numStack.size(), 0);

    // Try pop for multiple items with top item being different.
    for (int i = 0; i < 100; i++) {
      numStack.push(input);
    }
    numStack.push(88f);
    assertEquals(numStack.pop(), 88F);
    assertEquals(numStack.size(), 100);
  }

  // Test 5 - Test top method
  @Test
  void testTop() throws BadTypeException {
    // Add one item and check top of stack.
    numStack.push(13f);
    assertEquals(numStack.top(), 13f);
    assertEquals(numStack.size(), 1);

    // Test adding new item them checking top of the stack.
    numStack.push(88f);
    assertEquals(numStack.top(), 88f);
    assertEquals(numStack.size(), 2);
  }
}
