# week2 ISTD Info to Sys -- Inheritance

## motivations
1. to aviod redundancy by overridding same part of class over and over again,
2. this way more easy to maintain.
3. easy to understand the code.

## things to notice.
1. Subclass inherits all accessible data fields and methods from the superclass, except constructors
2. each class only allow one inheritance.

## super()
0. super can also be called for super class method when the method is being override.
1. Invoked explicitly or implicitly using ```super()``` in the constructor (If the keyword super is not explicitly used, the superclass’s no-arg constructor is automatically invoked
)
2. But if ”this” keyword is there, then there is no ”super” is called. (but it this constructor will call constructor)
3. Super class constructor will always be called.

Super constructor is always important to call as it can initialize some private data field that is very hard for you to know and initialize.
4. to aviod this problem: We prefer to put the no arg constructor always to avoid this problem. For every class, so the when any class wants to inherit this class, the no arg constructor can always be called.

## overriding
same method name. and same arg type

put the @Override to check

overriding cannot weaken the visibility, and private method cannot be overriden.

it is different from datatype hidding mechanism.

example: toString() method overriden.



## overloading 
same method name, different arg type.
 

## dynamic binding and polymorphism
dynamic binding: Which implementation is used will be determined dynamically by the Java Virtual Machine at runtime. This capability is known as dynamic binding. 

polymorphsim: An object of a subtype can be used wherever its supertype value is required. This feature is known as polymorphism.

## casting
casting to super class. This is up casting, can called **implicitly**.
And it will always succeed.

**Explicit** casting must be used when casting an object from a superclass to a subclass.  This type of casting may not always succeed.

## visibility modifier
![modifier](https://github.com/Emrys-Hong/programming_notes/blob/master/java/Info_to_Sys_notes/VisibilityModifiers.png)
