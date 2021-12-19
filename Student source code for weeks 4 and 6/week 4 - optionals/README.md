# Optionals demo

This application demonstrates the use of the Optional class. A loop is created that allows the user to type in some text. The text is sent to a class in the service layer that forwards the text to the Data Access Object (DAO) layer. The DAO class simulates a database lookup on the text. If the user types in "missing" (without quotes) the DAO class returns an empty Optional object. This causes the service class to throw a NoSuchElementException. Otherwise, the DAO class simply returns the text to the service wrapped by an Optional object.

The user can enter any text they want over and over again until they get tired of the very limited options.

# About the project

Please refer to the helpful comments in the .java files in the project. The class with the main method is com.promineotech.optional.Optionals.java. The DAO class (com.promineotech.optional.dao.OptionalDao.java shows how to create an Optional. The service class (com.promineotech.optional.service.OptionalService.java) demonstrates how to throw an exception if the Optional is empty.