/**
 * 
 */
package com.promineotech.optional.dao;

import java.util.Optional;

/**
 * Classes in the DAO layer are responsible for interacting with a data source. If the data source is a database, the
 * classes would perform CRUD operations on the tables. A data source can be a database, a flat file, a spreadsheet, a
 * queue, a REST or SOAP service - anything that data can be obtained from or sent to. Classes in the DAO layer are not
 * responsible for applying business rules - that is the purview of the service layer.
 * 
 * This class simulates reading from a data source. Obviously, it's a pretty weak simulation.
 * 
 * @author Promineo
 *
 */
public class OptionalDao {
  /**
   * This method returns an empty Optional if the given String is "missing". Otherwise, it returns an Optional that
   * wraps the given String.
   * 
   * @param search The text to "search" for
   * @return An Optional with the text if found. An empty Optional if the text is "missing". Literally. "missing".
   */
  public Optional<String> find(String search) {
    if ("missing".equals(search)) {
      /* Optional.empty() returns an empty Optional. */
      return Optional.empty();
    }

    /* Return the given String wrapped in an Optional. */
    return Optional.of(search);
  }
}
