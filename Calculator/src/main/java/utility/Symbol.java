package utility;

/**
 * Enum consisting of 7 constants relating to the symbol type of symbol of a Entry type of Symbol.
 *
 * @author Daniel Munteanu.
 */
public enum Symbol {
  PLUS("+"), MINUS("-"), TIMES("*"), DIVIDE("/"), LEFT_BRACKET("("), RIGHT_BRACKET(")"), INVALID(
      "Invalid"),;

  private final String calcSymbol;

  private Symbol(String calcSymbol) {
    this.calcSymbol = calcSymbol;
  }

  @Override
  public String toString() {
    return calcSymbol;
  }
}
