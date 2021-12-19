/**
 * 
 */
package com.promineotech.optional;

import java.util.NoSuchElementException;
import java.util.Scanner;
import com.promineotech.optional.service.OptionalService;

/**
 * This class demonstrates the use of the java.util.Optional class. It lets the user type in text from the command line.
 * It then sends the text to the data (DAO) layer where a simulated database lookup takes place. If the user types in
 * "missing" (without quotes), the DAO class returns an empty Optional, which causes the service class to throw a
 * java.util.NoSuchElementException. Any other string is simply returned as is.
 * 
 * @author Promineo
 *
 */
public class Optionals {
  private Scanner scanner = new Scanner(System.in);
  private OptionalService service = new OptionalService();

  /**
   * This is the entry point of the Java application. It simply creates an object of type Optionals and calls the
   * {@link #run()} method on that object.
   * 
   * @param args
   */
  public static void main(String[] args) {
    new Optionals().run();
  }

  /**
   * This method can access the instance variables of this class. A static method cannot. This method creates a loop
   * that collects some text from the user and forwards it to a class in the service layer (see
   * {@link OptionalService}). The user can simply enter an empty line (just press Enter) to terminate the loop.
   */
  private void run() {
    boolean done = false;

    while (!done) {
      System.out.print("Enter something: ");
      String search = scanner.nextLine();

      if (search.isEmpty()) {
        done = true;
      } else {
        try {
          String found = service.find(search);
          System.out.println("I found " + found + "!");
        } catch (NoSuchElementException e) {
          /* If the service throws a NoSuchElementException just print the message in the exception. */
          System.out.println(e.getMessage());
        }
      }
    }
  }
}
