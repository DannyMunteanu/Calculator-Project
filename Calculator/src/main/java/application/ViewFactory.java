package application;

/**
 * Used to follow the factory design pattern. Creating a new view based on the given input.
 * This is done via the createView method.
 */
public class ViewFactory {
  
  /**
   * Create view via parameter given.
   *
   * @param viewChoice choice of view.
   * @return instance of new selected view.
   */
  public ViewInterface createView(String viewChoice) {
    switch (viewChoice) {
      case "1":
        return CalcView.getInstance();
      case "2":
        return new AsciiView();
      default:
        return null;
    }
  }
}
