/**
 * 
 */
package com.promineotech.sort.model;

/**
 * This class is an abstraction of a person. Since we're only interested in the person's first name, it's a very simple
 * abstraction. The Person object is not inherently sortable because it does not implement the Comparable interface. If
 * it did, it would have the required compareTo method, which allows Java to sort Person objects in the natural order.
 * To sort in any other way, you would need to provide an object that implements the Comparator interface to allow Java
 * to do the sort.
 * 
 * @author Promineo
 *
 */
public class Person {
  private String firstName;

  /**
   * Constructor that sets the first name.
   * 
   * @param name
   */
  public Person(String name) {
    this.firstName = name;
  }

  /**
   * The toString method simply returns the first name.
   */
  @Override
  public String toString() {
    return getFirstName();
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * This method is used by the sorting algorithms to sort a list of people. It returns less than zero if the first
   * person's name is alphabetically less than the second person's name, greater than zero if the first person's name is
   * greater than the second person's name, and zero if the two names are equal. To that end, it relies on the compareTo
   * method in the String objects.
   * 
   * @param p1 The first person. The Java sort method will apply the parameters correctly.
   * @param p2 The second person
   * @return Less than zero if the first person's name is less than the second person's name, greater than zero if the
   *         first person's name is greater than the second, and zero if they are equal.
   * @throws NullPointerException Thrown if a person object or a person name is null.
   */
  public static int comparePeople(Person p1, Person p2) {
    return p1.firstName.compareTo(p2.firstName);
  }
}
