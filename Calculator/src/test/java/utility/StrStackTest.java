package utility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StrStackTest {
  StrStack strStack;

  // Test 1 - Create StrStack object
  @BeforeEach
  void constructStack() {
    strStack = new StrStack();
  }

  // Test 2 - Test size method on newly constructed stack
  @Test
  void testSize() {
    assertEquals(strStack.size(), 0);
  }

  // Test 3 - Test push method
  @Test
  void testPush() {
    // Add push one item. Check its in the stack.
    String input = "Blah Blah Blah";
    strStack.push(input);
    assertEquals(strStack.size(), 1);

    // Add 100 more inputs to test push can work multiple times.
    for (int i = 0; i < 100; i++) {
      strStack.push(input);
    }

    // There should be 101 items in the stack now.
    assertEquals(strStack.size(), 101);
  }

  // Test 4 - Test pop method
  @Test
  void testPop() throws BadTypeException {
    String input = "Blah Blah Blah";
    strStack.push(input);
    // Ensure the item we pop is the item added to top of stack.
    assertEquals(strStack.pop(), input);
    // Check that the stack is now empty since only item is popped.
    assertEquals(strStack.size(), 0);

    // Try pop for multiple items with top item being different.
    for (int i = 0; i < 100; i++) {
      strStack.push(input);
    }
    strStack.push("La La La");
    assertEquals(strStack.pop(), "La La La");
    assertEquals(strStack.size(), 100);
  }

  // Test 5 - Test top method
  @Test
  void testTop() throws BadTypeException {
    // Add one item and check top of stack.
    strStack.push("Hello");
    assertEquals(strStack.top(), "Hello");
    assertEquals(strStack.size(), 1);

    // Test adding new item them checking top of the stack.
    strStack.push("There");
    assertEquals(strStack.top(), "There");
    assertEquals(strStack.size(), 2);
  }
}
