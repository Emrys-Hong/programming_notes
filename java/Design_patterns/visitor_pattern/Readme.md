## when to use
when you want to separate some general functions out of a class and then put it as another class.

it helps you to add new functions to the class, you just need to define a new class, 
and see how is the method implemented in that class

traditional way:
put things through processing

OOP way:
visitor "processing" process by visiting each object.

When you called visitable by a visitor, you dont have to write all the "if statements", it is called a double dispatch. because ```accept``` call ```visit``` method in the corresponding class.

## how to use
see code structure
