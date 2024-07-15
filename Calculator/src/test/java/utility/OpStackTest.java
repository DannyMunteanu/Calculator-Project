package utility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OpStackTest {
  OpStack opStack;

  // Test 1 - Create OpStack object
  @BeforeEach
  void constructStack() {
    opStack = new OpStack();
  }

  // Test 2 - Test size method on newly constructed stack
  @Test
  void testSize() {
    assertEquals(opStack.size(), 0);
  }

  // Test 3 - Test push method
  @Test
  void testPush() {
    // Add push one item. Check its in the stack.
    Symbol input = Symbol.PLUS;
    opStack.push(input);
    assertEquals(opStack.size(), 1);

    // Add 100 more inputs to test push can work multiple times.
    for (int i = 0; i < 100; i++) {
      opStack.push(input);
    }

    // There should be 101 items in the stack now.
    assertEquals(opStack.size(), 101);
  }

  // Test 4 - Test pop method
  @Test
  void testPop() throws BadTypeException {
    Symbol input = Symbol.PLUS;
    opStack.push(input);
    // Ensure the item we pop is the item added to top of stack.
    assertEquals(opStack.pop(), input);
    // Check that the stack is now empty since only item is popped.
    assertEquals(opStack.size(), 0);

    // Try pop for multiple items with top item being different.
    for (int i = 0; i < 100; i++) {
      opStack.push(input);
    }
    opStack.push(Symbol.MINUS);
    assertEquals(opStack.pop(), Symbol.MINUS);
    assertEquals(opStack.size(), 100);
  }

  // Test 5 - Test top method
  @Test
  void testTop() throws BadTypeException {
    // Add one item and check top of stack.
    opStack.push(Symbol.PLUS);
    assertEquals(opStack.top(), Symbol.PLUS);
    assertEquals(opStack.size(), 1);

    // Test adding new item them checking top of the stack.
    opStack.push(Symbol.MINUS);
    assertEquals(opStack.top(), Symbol.MINUS);
    assertEquals(opStack.size(), 2);
  }
}
