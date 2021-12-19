/**
 * 
 */
package com.promineotech.streaming.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;
import com.promineotech.streaming.dao.RepeatDao;
import com.promineotech.streaming.model.RepeatingName;

/**
 * This class gets a list of repeating names in no particular order. It then converts the list to a map of String ->
 * List<{@link RepeatingName}> where the String key is the repeating character and the list value is a list of repeating
 * names that all have the same repeating character (i.e., a -> [Baak, Baar, Baaz]).
 * 
 * This class has methods for a Stream/Method Reference approach ({@link #findRepeatingNames()}), a Stream/Lambda
 * approach ({@link #findRepeatingNamesLambda()}), and a traditional approach ({@link #findRepeatingNamesTraditional()})
 * 
 * @author Promineo
 *
 */
public class RepeatService {

  private RepeatDao repeatDao = new RepeatDao();

  /**
   * Obtain the list of names from the DAO and return a map of repeating character -> List<{@link RepeatingName}> so
   * that names with the same repeating character are grouped together (i.e., n -> [Lunn, Penn, Unni, Unno]). The list
   * of repeating names in each group are sorted alphabetically.
   * 
   * @return
   */
  public Map<String, List<RepeatingName>> findRepeatingNames() {
    /*
     * This method uses Streams and Method References to return a map of repeating char -> List<RepeatingName>.
     * 
     * How this works: A list of names is retrieve from the DAO (repeatDao.getLastNames()). The list is converted to a
     * Stream of String (stream()). Names without repeating characters are removed from the Stream
     * (filter(RepeatingName::hasRepeatingCharacter)). The Stream of String is converted to a Stream of RepeatingName
     * (map(RepeatingName::new)). The Stream of RepeatingName is sorted alphabetically (sorted()). The Stream of
     * RepeatingName is then collected into a map of repeating character -> List<RepeatingName>
     * (collect(Collectors.groupingBy(RepeatingName::getRepeatingChar)).
     */
    // @formatter:off
    return repeatDao.getLastNames().stream()
        .filter(RepeatingName::hasRepeatingCharacter)
        .map(RepeatingName::new)
        .sorted()
        .collect(Collectors.groupingBy(RepeatingName::getRepeatingChar));
    // @formatter:on
  }

  /**
   * This method combines Streams and Lambda expressions to return a map of repeating char ->
   * List<{@link RepeatingName}>.
   * 
   * @return
   */
  public Map<String, List<RepeatingName>> findRepeatingNamesLambda() {
    // @formatter:off
    return repeatDao.getLastNames().stream()
        .filter(name -> RepeatingName.hasRepeatingCharacter(name))
        .map(name -> new RepeatingName(name))
        .sorted()
        .collect(Collectors.groupingBy(repeatName -> repeatName.getRepeatingChar()));
    // @formatter:on
  }

  /**
   * This method returns a map of repeating char -> List<{@link RepeatingName}> using a traditional (pre-Java 8)
   * approach. You can see that there is a <b>lot</b> more code than the Streams approach and it is less readable.
   * 
   * Note that the names are sorted first so that they will remain sorted when put into their respective lists. This
   * will be slower than either of the Streams approach in which the sort occurs after filtering.
   * 
   * @return
   */
  public Map<String, List<RepeatingName>> findRepeatingNamesTraditional() {
    List<String> names = new ArrayList<>(repeatDao.getLastNames());
    names.sort(Comparator.naturalOrder());

    Map<String, List<RepeatingName>> nameMap = new TreeMap<>();

    for (String name : names) {
      if (RepeatingName.hasRepeatingCharacter(name)) {
        RepeatingName repeatName = new RepeatingName(name);
        List<RepeatingName> repeatNames = nameMap.get(repeatName.getRepeatingChar());

        if (Objects.isNull(repeatNames)) {
          repeatNames = new LinkedList<>();
          nameMap.put(repeatName.getRepeatingChar(), repeatNames);
        }

        repeatNames.add(repeatName);
      }
    }

    return nameMap;
  }
}
