/**
 * 
 */
package com.promineotech.sort.dao;

import java.util.ArrayList;
import java.util.List;
import com.promineotech.sort.model.Person;

/**
 * This class represents a Data Access Object (DAO). It simulates retrieving data from a database table. DAO classes
 * tend to operate at the table (or single source) perspective. But DAO classes can also operate at the "use case"
 * level, combining data from several tables in a single query with join statements.
 * 
 * Besides accessing a table, DAO classes can also access data from REST APIs, queues, SOAP APIs, anything that can act
 * as a data source - even flat files or spreadsheets. The purpose of a DAO class is to get and put the data. The
 * purpose of the service layer is to apply business rules to the data obtained by the DAO layer.
 * 
 * @author Promineo
 *
 */
public class SortDao {
  /*
   * This is the unsorted list of Person objects. Note that because List.sort sorts the list in place, it needs to
   * modify the list element positions. List.of returns an unmodifiable list, so List.of must be wrapped with a list
   * constructor that returns a modifiable list.
   */
  List<Person> people = new ArrayList<>(
      List.of(new Person("Mary"), new Person("Arif"), new Person("Huan"), new Person("Uri"), new Person("Magy"),
          new Person("Moss"), new Person("Ebbe"), new Person("Tse"), new Person("Gino"), new Person("Udi")));

  /**
   * 
   * @return An unsorted list of first names.
   */
  public List<Person> getPeople() {
    return people;
  }
}
