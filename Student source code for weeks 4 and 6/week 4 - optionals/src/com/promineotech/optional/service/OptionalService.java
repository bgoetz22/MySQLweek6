/**
 * 
 */
package com.promineotech.optional.service;

import java.util.NoSuchElementException;
import com.promineotech.optional.dao.OptionalDao;

/**
 * Classes in the service layer are responsible for applying business rules to the data going to and from the DAO layer.
 * In this case, the class simply throws an exception if the DAO layer can't find the search text.
 * 
 * @author Promineo
 *
 */
public class OptionalService {
  private OptionalDao dao = new OptionalDao();

  /**
   * This method calls the DAO layer to search for the given text. If the text is found, it is simply returned. If the
   * text is not found (the returned Optional is empty), a NoSuchElementException is thrown.
   * 
   * @param search The text to search for
   * @return The found text
   * @throws NoSuchElementException Thrown if the text isn't found
   */
  public String find(String search) {
    return dao.find(search).orElseThrow(() -> new NoSuchElementException("It appears that " + search + " is missing."));
  }

}
