# ISTD Info to Sys week1

## static method
When to use static method:

static method or variable is shared by the entire class instead of a instance.

instance method can access both static variable and instance variable.

static method can only access both static variable.

static method cannot be overriden.

## pointers( variables)
to the primitive type can be "changed"

to the reference type cannot be overriden.

## passing variable functions
the previous variable will be overriden by the new arg in the functions.

we can use ```this.variable``` to reference the variable in the class.

(args passed in the function is called a heap.)

## constructor
if the arg constructor is provided. then the no arg constructor will not be provided.

so it is good to have the no arg constructor.

Abstract classes also have pointers.


## data fields
Design principles for easier maintainence and protect data:
1. Minimize the accessibility of classes and members
2. In public classes, use accessor methods, not public attributes

![visibility modifiers](https://github.com/Emrys-Hong/programming_notes/blob/master/java/Info_to_Sys_notes/VisibilityModifiers.png)

## passing object to methods
if passing "myAnimal" created by ```Animal myAnimal = new Animal();``` as an argument to a method, the myAnimal as a reference type will be stored in the stack.

the new Animal() will be store in the heap, which is dynamic.

so when changing values in the pointer will not change new Animal class.