/**
 * 
 */
package com.promineotech.streaming.dao;

import java.util.List;

/**
 * This class is in the Data Access Object (DAO) layer. Classes in this layer normally interact with a data source (like
 * a database, flat file, queue or spreadsheet). In this case, it simply returns a list of sample data without talking
 * to a data source.
 * 
 * @author Promineo
 *
 */
public class RepeatDao {
  /* This is a list of unsorted names obtained from the employees database. */
  List<String> lastNames = List.of("Peac", "Peha", "Erde", "Swan", "Peyn", "Gils", "Baek", "Luby", "Baca", "Czap",
      "Zyda", "Baja", "Peir", "Erva", "Bade", "Gire", "Erie", "Luck", "Baer", "Badr", "Bain", "Bahi", "Gini", "Bale",
      "Luft", "Luce", "Unno", "Baba", "Baig", "Pell", "Gihr", "Luga", "Lunt", "Bahl", "Undy", "Erol", "Bahk", "Peck",
      "Gide", "Bage", "Peak", "Erdi", "Bahr", "Lunn", "Pena", "Gilg", "Suri", "Luks", "Cyre", "Erni", "Luff", "Peng",
      "Luiz", "Luca", "Baak", "Sury", "Gips", "Penn", "Ibel", "Pews", "Swab", "Pfau", "Bala", "Erez", "Bail", "Pelc",
      "Cyne", "Pehl", "Baar", "Ertl", "Swen", "Pepe", "Bach", "Babu", "Luit", "Baez", "Pero", "Penz", "Bael", "Baik",
      "Zykh", "Suwa", "Peot", "Back", "Luke", "Lueh", "Luon", "Lung", "Perl", "Babb", "Gill", "Pelz", "Baby", "Peek",
      "Lupu", "Erbe", "Lund", "Unni", "Gist", "Erev", "Luef", "Perz", "Gien", "Luan", "Baaz");

  /**
   * @return the lastNames
   */
  public List<String> getLastNames() {
    return lastNames;
  }

}
