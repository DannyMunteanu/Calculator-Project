package utility;

/**
 * Exception Class called within the Entry class if the Type is mismatched. BadTypeExcpetion takes
 * in string error message given by instance that it is thrown in.
 *
 * @author Daniel Munteanu.
 */
@SuppressWarnings("serial")
public class BadTypeException extends Exception {

  /**
   * Constructor for Exception takes in a String error message.
   *
   * @param message String that displays the mismatch message defined in Entry class.
   */
  public BadTypeException(String message) {
    super(message);
  }

}
