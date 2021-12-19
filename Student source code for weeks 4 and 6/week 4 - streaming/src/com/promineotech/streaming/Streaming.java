/**
 * 
 */
package com.promineotech.streaming;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.promineotech.streaming.model.RepeatingName;
import com.promineotech.streaming.service.RepeatService;

/**
 * This class is the entry point for the Streams example. This project is structured in a controller-service-DAO
 * architecture. The controller is this class, which is in the base package. The service layer is in the .service
 * package. The service layer is responsible for applying business rules and transformations of data obtained by the
 * Data Access Object (DAO) layer. The DAO layer is in the .dao package. This layer is responsible for interacting with
 * the data source directly. Data Transfer Objects (DTOs) are generally Plain Old Java Objects (POJOs), which are found
 * in the .model package. These files simply shuffle data around between the different layers of the application.
 * 
 * @author Promineo
 *
 */
public class Streaming {
  private RepeatService repeatService = new RepeatService();

  /**
   * The main method is the entry point for the Java application. The Java Virtual Machine (JVM) calls this method when
   * the application is started. This method simply converts from a static method (main) to an instance method (run).
   * Instance methods, in general, are easier to work with. They allow access to instance variables (like the repeat
   * service) and they work better with mocking libraries when testing.
   * 
   * @param args
   */
  public static void main(String[] args) {
    new Streaming().run();
  }

  /**
   * This is the method that does all the work. It retrieves a map of names that have repeating characters in them. The
   * map is keyed by the repeating character. The key points to a list of names that have the same repeating character
   * as the key. This method uses a Stream to convert the map of names into a printable format.
   */
  private void run() {
    /*
     * You can also call repeatService.findRepeatingNamesTraditional() and repeatService.findRepeatingNamesLambda().
     */
    Map<String, List<RepeatingName>> names = repeatService.findRepeatingNames();

    /*
     * This Stream is a little more complicated than what I like to see but it does illustrate the power and compactness
     * of Streams. The code works like this: first, the key/value pairs are iterated in order
     * (names.entrySet().forEach). The key is printed, along with a colon-space. At this point, the values are a list of
     * RepeatingName. A Stream is then created on the list of RepeatingName (entry.getValue().stream()). The Stream of
     * RepeatingName is then converted to a Stream of String (map(RepeatingName::getName)). The Stream of names (String)
     * is then collected into a list of names (collect(Collectors.toList())) and the list is added to the output for the
     * line. Behind the scenes, Java calls the toString method on the list, which prints the names in a comma-separated
     * form surrounded by square brackets (i.e., "a: [Baak, Baar, Baaz]").
     */
    // @formatter:off
    names.entrySet().forEach(entry -> 
        System.out.println(entry.getKey() + ": " +
            entry.getValue().stream()
                .map(RepeatingName::getName)
                .collect(Collectors.toList())));
    // @formatter:on
  }

}
