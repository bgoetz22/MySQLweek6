# Sorting

There are several ways to sort lists in Java. Traditionally, lists have been sorted using the Collections class. If the list implements the Comparable interface, Java can use the required compareTo method to perform sorting. The compareTo method compares two list objects and returns less than 0 if the first object is "less than" the second, greater than 0 if the first object is "greater than" the second, and 0 if the objects are "equal". It looks like this:

```
Collections.sort(list);
```

If the list doesn't implement the Comparable interface, you can still sort the list by providing a "Comparator". A Comparator is something that provides functionality through the Comparator interface. This can be a class, an anonymous inner class, a Lambda expression or a Method Reference. Assuming that you have a comparator implementation assigned to a variable named "comp", you would sort like this:

```
Collections.sort(list, comp);
```

Starting with Java 8, the List interface supports the sort method. So, given a List named list, you can call the sort method on the object directly:

```
list.sort();
list.sort(comp);
```

# About the project

Please refer to the individual source files in this project for additional comments and explanations. The application entry point (with the main method) is com.promineotech.sort.MySortApp.java.