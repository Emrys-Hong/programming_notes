
# Nested  class
A class definition can contain class definitions. We call these classes ​nested classes​​.


This is typically done when you have classes that logically depend on the outer class and are used together with the outer class.




# Inner class
A nested class that is not declared static is called an ​Inner Class​​.

● To instantiate an inner class, you need an instance of the outer class, which is

usually called the ​enclosing class​​.

● The inner class can access all methods and variables of the enclosing outer class.

```java
public​ ​class​ ​OuterClass​ {
    int​ a;
    OuterClass(){ 
        a = ​10​; 
    }
​    void​ ​outerPrintA​(){ 
        System.out.println(a); 
    }
​   
    class​ ​InnerClass​{ ​
        int​ c;

    InnerClass(){ 
        c = ​100​; 
    }
​    void​ ​innerPrintA​(){ 
        System.out.println(a); 
    }
    OuterClass ​giveBackOuter​(){ ​
        return​ OuterClass.​this​; 
    } 
    }
}
```

# static nested class
By declaring a nested class as static, it is known as a ​`static nested class`.

● It can only access static variables and methods in the outer class.

● It can be instantiated without an instance of the outer class.

A static nested class behaves like a top-level class and is a way to organize classes that are used only by some other classes.