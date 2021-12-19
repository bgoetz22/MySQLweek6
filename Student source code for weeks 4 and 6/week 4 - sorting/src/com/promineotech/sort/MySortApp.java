/**
 * 
 */
package com.promineotech.sort;

import java.util.List;
import com.promineotech.sort.model.Person;
import com.promineotech.sort.model.SortType;
import com.promineotech.sort.service.SortService;

/**
 * This is the entry point to the sorting demonstration application.
 * 
 * @author Promineo
 *
 */
public class MySortApp {
  private SortService sortService = new SortService();

  /**
   * This method simply creates an object of type MySortApp and calls the run method on it. This gets us away from
   * static methods, which can't be overridden and can't be tested very well. It also lets the instance methods access
   * instance variables declared in this class.
   * 
   * @param args
   */
  public static void main(String[] args) {
    new MySortApp().run();
  }

  /**
   * The run method calls the sort service to sort a list of names. You can specify the sorting method used by changing
   * variable <em>sortType</em>.
   */
  private void run() {
    SortType sortType = SortType.NORMAL_CLASS;

    List<Person> people = sortService.getSortedNameList(sortType);
    print(people, sortType);
  }

  /**
   * This method simply prints each name to the console, one name on each line. It uses the "style" that is specified in
   * the sort type. Note that System.out.println(person) prints the same result as
   * System.out.println(person.getFirstName()) because it calls the toString method, which simply prints the first name.
   * 
   * @param people
   * @param type
   */
  private void print(List<Person> people, SortType type) {
    switch (type) {
      case LAMBDA:
        /*
         * Note that a Lambda expression with a single parameter does not need parentheses around the parameter.
         */
        people.forEach(person -> System.out.println(person));
        break;

      /*
       * The method being referenced is the println method on the "out: class variable (static) in the System class.
       * That is why the method reference operator is between out and println.
       */
      case METHOD_REFERENCE:
        people.forEach(System.out::println);
        break;

      /*
       * You can see that the code for the Lambda expression and the method reference is much more concise than the
       * traditional approach.
       */
      case ANONYMOUS_INNER_CLASS:
      case NORMAL_CLASS:
        for (Person person : people) {
          System.out.println(person);
        }

        break;

      default:
        throw new RuntimeException("Unknown sort type: " + type);

    }
  }

}
