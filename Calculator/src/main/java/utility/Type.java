package utility;

/**
 * Enum of 4 constants representing the Type of Entry.
 *
 * @author Daniel Munteanu.
 */
public enum Type {
  FLOAT("Float"), STRING("String"), SYMBOL("Symbol"), INVALID("Invalid"),;

  private final String calcType;

  private Type(String calcType) {
    this.calcType = calcType;
  }

  @Override
  public String toString() {
    return calcType;
  }
}
