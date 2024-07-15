package application;

import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Skeleton code for a terminal based calculator that reads an expression from the user and
 * evaluates it and prints out the answer.
 */
public class AsciiView implements ViewInterface {
  // The current question that the calculator must solve: entered like ?3*(5+4)
  private String question;

  // This method will be injected so we can ask the controller to calculate
  Runnable doCalculation = null;

  // This method changes how the calculator will evaluate the question
  Consumer<OpType> setCalculatorType = null;


  private void menu() {
    Scanner s = new Scanner(System.in);
    boolean finished = false;
    help();

    while (!finished && s.hasNext()) {
      String t = s.next();
      switch (t.toUpperCase().charAt(0)) {
        case 'C':
          if (question != null) {
            doCalculation.run();
          }
          break;
        case 'S':
          setCalculatorType.accept(OpType.STANDARD);
          System.out.println("Selected -> Standard Calculator (Infix Mode)");
          break;
        case 'R':
          setCalculatorType.accept(OpType.REV_POLISH);
          System.out.println("Selected -> Reverse Polish Calculator (Postfix Mode)");
          break;
        case '?':
          System.out.println("Enter The Expression Below");
          question = s.next();
          question += s.nextLine();
          break;
        case 'Q':
          System.out.println("Bye");
          finished = true;
          break;
        default:
          help();
          break;
      }
    }
    s.close();
  }

  private void help() {
    System.out.println("Use one of the following:");
    System.out.println("  ? - to set expression");
    System.out.println("  C - to calculate");
    System.out.println("  S - change to a standard calculator");
    System.out.println("  R - change to a reverse polish calculator");
    System.out.println("  Q - to exit");
  }

  @Override
  public String getExpression() {
    return question;
  }

  @Override
  public void setAnswer(String answer) {
    System.out.println(answer);
  }

  @Override
  public void addCalculateObserver(Runnable f) {
    doCalculation = f;
  }

  @Override
  public void addTypeObserver(Consumer<OpType> c) {
    setCalculatorType = c;
  }

  @Override
  public void startView() {
    menu();
  }

}
