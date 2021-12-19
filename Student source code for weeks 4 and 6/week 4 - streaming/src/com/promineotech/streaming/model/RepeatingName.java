/**
 * 
 */
package com.promineotech.streaming.model;

import java.util.Objects;
import javax.annotation.processing.Generated;

/**
 * This class is a little more than a Plain Old Java Object (POJO). POJOs normally consist of instance variables with
 * getters and setters - and not much more.
 * 
 * @author Promineo
 *
 */
public class RepeatingName implements Comparable<RepeatingName> {
  private String repeatingChar;
  private String name;

  /**
   * This constructor accepts a name and finds the repeating character in the name.
   * 
   * @param name The name, which must contain a repeating character.
   * @throws NullPointerException Thrown if the name is null.
   * @throws IllegalArgumentException Thrown if the name is empty or blank.
   */
  public RepeatingName(String name) {
    this.repeatingChar = findRepeatingChar(name);

    Objects.requireNonNull(this.repeatingChar, "The name " + name + " must have one or more repeating characters!");
  }

  /**
   * @return the repeatingChar
   */
  public String getRepeatingChar() {
    return repeatingChar;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Check that the given name has a repeating character.
   * 
   * @param name The name to check.
   * @return {@code true} if the name has a repeating character, {@code false} otherwise.
   */
  public static boolean hasRepeatingCharacter(String name) {
    return findRepeatingChar(name) != null;
  }

  /**
   * Find a repeating character in the given name.
   * 
   * @param name The name to test.
   * @return The repeating character if there is one, otherwise {@code null}.
   * @throws NullPointerException Thrown if the name is null.
   * @throws IllegalArgumentException Thrown if the name is empty or blank.
   */
  private static String findRepeatingChar(String name) {
    Objects.requireNonNull(name, "Name must not be null");

    if (name.trim().isEmpty()) {
      throw new IllegalArgumentException("Name must not be null or empty");
    }

    String trimmed = name.trim();
    char lastChar = name.charAt(0);

    for (int index = 1; index < trimmed.length(); index++) {
      char thisChar = name.charAt(index);

      if (lastChar == thisChar) {
        return Character.toString(thisChar);
      }

      lastChar = thisChar;
    }

    return null;
  }

  /**
   * Required by the {@link Comparable} interface. This method returns a positive number this object is greater than the
   * given object. It returns a negative number if this object is less than the given object. It returns zero if this
   * object is the same as the given object.
   * 
   * To determine the relationship between this object and the given object, the method first checks the relationship
   * between the repeating character in this object versus the given object. If the repeating character is the same in
   * both objects, it compares the names in both objects.
   * 
   * The constructor prohibits null or blank names and repeating characters so a null check does not have to be
   * performed in this method.
   * 
   * @param that The object to compare to this object.
   */
  @Override
  public int compareTo(RepeatingName that) {
    int cmp = this.repeatingChar.compareTo(that.repeatingChar);

    if (cmp == 0) {
      cmp = this.name.compareTo(that.name);
    }

    return cmp;
  }

  /**
   * Convert this object to a String representation.
   */
  @Override
  @Generated(date = "2021-08-01T09:15:18:352-0600", value = "Spring Tool Suite, version 4.11.0.RELEASE")
  public String toString() {
    return "RepeatingName [repeatingChar=" + repeatingChar + ", name=" + name + "]";
  }


}
