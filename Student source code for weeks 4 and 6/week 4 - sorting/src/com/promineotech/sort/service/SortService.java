/**
 * 
 */
package com.promineotech.sort.service;

import java.util.Comparator;
import java.util.List;
import com.promineotech.sort.dao.SortDao;
import com.promineotech.sort.model.Person;
import com.promineotech.sort.model.SortType;

/**
 * This service takes the raw data returned by the DAO layer and sorts it according to the specified method.
 * 
 * @author Promineo
 *
 */
public class SortService {
  private SortDao sortDao = new SortDao();

  /**
   * This method calls a method in the DAO layer to retrieve a list of person names. It then sorts the names using the
   * requested method and returns the sorted list.
   * 
   * @param type The sort type
   * @return A sorted list
   */
  public List<Person> getSortedNameList(SortType type) {
    List<Person> people = sortDao.getPeople();
    Comparator<Person> comp;

    switch (type) {
      case ANONYMOUS_INNER_CLASS:
        /*
         * People complain that anonymous inner classes (classes within methods that have no name) are ugly. Compared
         * with the elegance of a Lambda expression or a method reference, it is difficult to disagree. Anonymous inner
         * classes are implementations of interfaces that supply a body (within the curly braces) but no name. They can
         * be assigned to a variable or used as a parameter. Since they are concrete classes they must provide
         * implementations for all methods specified in the interface. They can't be accessed by name, so they are
         * mostly used as one-off solutions.
         */
        comp = new Comparator<Person>() {
          @Override
          public int compare(Person p1, Person p2) {
            return Person.comparePeople(p1, p2);
          }
        };

        break;

      case LAMBDA:
        /*
         * A functional interface has a single method that is not a default or static method, and does not override a
         * method from the Object class. This is important since Java needs to know what function the Lambda is being
         * used for. If there is more than one qualifying method in the interface you cannot use a Lambda expression.
         *
         * If you are supplying a function for a functional interface you don't need to do anything remotely like using
         * the method name as specified in the functional interface. Since Java knows exactly which method you are using
         * the Lambda for, it just looks at the number and type of parameters and the return type. This is the thing
         * that trips people up when learning about Lambdas. In the Comparator interface, the single method is named
         * "compare". The parameter types are unspecified Generics so you can use any parameter type but they must be
         * the same. The return on the Lambda must be an int. Other than those restrictions, the Lambda can do anything
         * it wants in any way that it wants.
         * 
         * Since the Comparator uses Generics (Comparator<Person>), the two parameters it passes to the compare method
         * will be Person types. So, even though the interface itself allows for different types, the method parameters
         * types are locked in because the variable is of type Comparator<Person>. This will produce an error if the
         * Lambda doesn't treat the parameters as Person types.
         */

        /* The full form of the Lambda looks like this: */
        comp = (Person p1, Person p2) -> {
          return Person.comparePeople(p1, p2);
        };

        /* Since Java can usually infer the parameter types you can omit them */
        comp = (p1, p2) -> {
          return Person.comparePeople(p1, p2);
        };

        /*
         * And if you're just returning something from a single statement you can omit the curly braces, the return
         * keyword, and the ending semicolon inside the body.
         */
        comp = (p1, p2) -> Person.comparePeople(p1, p2);
        break;

      case METHOD_REFERENCE:
        /*
         * Similar to the rules of a Lambda, the method reference must agree on parameter type(s) and return value. And
         * like the Lambda, Person.comparePeople must take exactly two parameters of type Person, and it must return an
         * int.
         */
        comp = Person::comparePeople;
        break;

      case NORMAL_CLASS:
        /*
         * This is the simplest form but the most obfuscated. You need to take a look at the MyComparator definition to
         * see what it is doing.
         */
        comp = new MyComparator();
        break;

      default:
        throw new RuntimeException("Unhandled sort type: " + type);

    }

    /*
     * List.sort sorts the list in place. If you have an unmodifiable list, it will generate an error when the list is
     * sorted. It would be nice if List.sort returned the list instead of void so you could return it on the same line
     * (return people.sort(comp);). But it doesn't so you can't. :(
     */
    people.sort(comp);
    return people;
  }

  static class MyComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
      return Person.comparePeople(p1, p2);
    }

  }
}
