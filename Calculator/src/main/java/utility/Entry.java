package utility;

import java.util.Objects;

/**
 * Entry contains value which can be either a Float, String or Symbol. Depending on the value type,
 * there is a corresponding Enum attribute type.
 *
 * @author Daniel Munteanu.
 */

public class Entry {

  /**
   * Constructors for Entry class for each possible type of instance. Assigning the corresponding
   * type to the Entry based on the given constructor.
   */

  private Object value;
  private Type type;

  /**
   * Assign a float to value and assign the Type as FLOAT.
   *
   * @param floatEntry value of Entry.
   */
  public Entry(Float floatEntry) {
    value = floatEntry;
    type = Type.FLOAT;
  }

  /**
   * Assign a string to value and assign the Type as STRING.
   *
   * @param stringEntry the value of Entry.
   */
  public Entry(String stringEntry) {
    value = stringEntry;
    type = Type.STRING;
  }

  /**
   * Assign a symbol type to value and assign Type as SYMBOL.
   *
   * @param symbolEntry the value of Entry.
   */
  public Entry(Symbol symbolEntry) {
    value = symbolEntry;
    type = Type.SYMBOL;
  }

  /**
   * Returns value, if Entry instance constructed with float.
   *
   * @return Output of the value of Entry.
   * @throws BadTypeException Thrown if Type is mismatched.
   */
  public Float getValue() throws BadTypeException {
    if (type != Type.FLOAT) {
      throw new BadTypeException("INVALID - VALUE MUST BE INSTANCE OF FLOAT");
    }
    return (Float) value;
  }

  /**
   * Returns value, if Entry instance constructed with String.
   *
   * @return Output of the value of Entry.
   * @throws BadTypeException Thrown if Type is mismatched.
   * 
   */
  public String getString() throws BadTypeException {
    if (type != Type.STRING) {
      throw new BadTypeException("INVALID - VALUE MUST BE INSTANCE OF STRING");
    }
    return (String) value;
  }

  /**
   * Returns value, if Entry instance constructed with Symbol.
   *
   * @return Output of the value of Entry.
   * @throws BadTypeException Thrown if Type is mismatched.
   */
  public Symbol getSymbol() throws BadTypeException {
    if (type != Type.SYMBOL) {
      throw new BadTypeException("INVALID - VALUE MUST BE INSTANCE OF SYMBOL");
    }
    return (Symbol) value;
  }

  /**
   * Return the Type attribute of Entry.
   *
   * @return type Enum Type associated to the Entry.
   */
  public Type getType() {
    return type;
  }

  /**
   * Checks if the Entry instance and Object parameter are equal. By checking if share the same
   * class and have the same string representation of value.
   *
   * @param otherObject The Object to be compared with the current Entry in which method is called.
   * @return True if the 2 Objects share the same class and string representation of value.
   */
  @Override
  public boolean equals(Object otherObject) {
    if (otherObject instanceof Entry) {
      Entry otherEntry = (Entry) otherObject;
      if ((type == otherEntry.type)
          && (String.valueOf(value).equals(String.valueOf(otherEntry.value)))) {
        return true;
      }
    }
    return false;
  }

  /**
   * Using the value and type attributes of entry a unique integer is generated. Entries with the
   * same value and type will return the same integer when hashCode is called.
   *
   * @return The hashed value of the Entry
   */
  @Override
  public int hashCode() {
    return Objects.hash(value, type);
  }

}
