package application;

import java.util.Scanner;

/**
 * A driver class that sets up the MVC framework and begins the application.
 */
public class Driver {
  
  /**
   * The entry point for the calculator. Decided to use Command line inputs to initiate views.
   * Uses factory design to create views.
   *
   * @param args ignored
   */
  public static void main(String[] args) {
    ViewFactory factory = new ViewFactory();
    ViewInterface view = null;
    Scanner s = new Scanner(System.in);
    
    //Determine which view to select based on user input
    while (view == null) {
      System.out.println("Enter View Interface Below ~~ 1 = GUI MODE | 2 = ASCII MODE ~~");
      String choice = s.next();
      view = factory.createView(choice);
    }
    s.close();

    CalcModel model = new CalcModel();
    
    new CalcController(model, view);
    // All ready so begin the interface.
    view.startView();
  }
}
