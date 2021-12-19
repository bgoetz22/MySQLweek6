# Streams demonstration

Streams are functional pipelines. They resemble automated assembly lines where each "station" is a function that modifies the Stream in some way. Streams can be sorted, limited to a specific size, filtered, have the type changed, added, averaged, counted, reassembled and more. 

Changing the type of Stream in mid-stream is one way they are much different from Collections. You can change the type of Collection, to be sure, but not in a single chained function call!

Streams have a single creation method, zero or more intermediate methods, and a single termination methods. Technically, you can create a Stream without a termination method but then it wouldn't do anything.

Streams are single-use pipelines - you can't reset them and use them again. They can be reused within methods (as a Stream is defined within a method), but you can only use them once for any given method call.

The beauty of Streams is that they pack a lot of power into a very compact space. Used properly they will enhance, clarify and beautify your code.

# About the project

Please refer to the project files for additional details and explanations. Start with com.promineotech.streaming.Streaming.java, which is the class that contains the main method.