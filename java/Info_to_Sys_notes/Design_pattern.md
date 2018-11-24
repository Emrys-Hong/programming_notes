# Design patterns

## Template Method Design pattern
To achieve a algorithm with a fixed common structure or fixed procedure.

For example for brewing caffine bevarages, we have a fixed procedure, but how to implement it is implemented in the subclass.
```java
public​ ​abstract​ ​class​ ​CaffeineBeverage​ {
​   final​ ​void​ ​prepareRecipe​(){ 
        boilWater();
        brew();
        addCondiments();
        pourInCup();
    }
    ​abstract​ ​void​ ​brew​();
    ​abstract​ ​void​ ​addCondiments​();
    ​void​ ​boilWater​(){
        System.out.println(​"Boiling Water"​); 
    }
    ​void​ ​pourInCup​(){
        System.out.println(​"Pouring in Cup"​); 
    }
}
```
In subclass, we implement the methods.
```java
class​ ​GourmetCoffee​ ​extends​ ​CaffeineBeverage​{ ​
    @Override​ ​void​ ​brew​() {
        System.out.println(​"Put in Coffee Maker"​); 
    }
    ​@Override​ ​void​ ​addCondiments​() {
        System.out.println(​"Adding nothing, because GourmetCoffee"​); 
    }
}
```
[AsyncTasks using template method](Android-lesson3.md##AsyncTasks)

## static factory method

A ​static factory method​​ is a __static__ method in a class definition
that returns an instance of that class. (​Attention: this is not the factory design pattern)​ .

Advantage:
1. You can overload your constructor to initialize your class with different states, but you are constrained by Java to have the same name for all constructors.
1. On the other hand, you can give your static factory method meaningful names to describe what you are doing.

(We want to strict first, and then release, it is easier)
```java
public​ ​class​ ​Tea​ { ​
    private​ ​boolean​ sugar;
​    private​ ​boolean​ milk;
    Tea(​boolean​ sugar, ​boolean​ milk){ ​
        this​.sugar = sugar;
​        this​.milk = milk; 
    }
​    public​ ​static​ Tea ​teh​(){
​        return​ ​new​ Tea(​true​, ​true​); 
    }
​    public​ ​static​ Tea ​tehkosong​(){
​        return​ ​new​ Tea(​false​, ​true​ ); 
    }
}
```
[Toast](Android-lesson2.md##Toast)
1. The Toast class constructor is actually public. It is used when you want to customize
the design of your toast.

2. Most of the time, there is no need to, so ​makeText()​​ gives you the standard Toast
design.

## builder Design pattern
static method usually make us to implement a constructors if there is a lot of argument.
We may solve this problem by introducing a ​static nested class​​, usually called a b​ uilder class​​ that has
- methods to allow the user to specify the options one by one
- One method that returns the actual object
  
you should take the constructors private

for example:
```java
public​ ​class​ ​TeaTwo​ { ​
    private​ ​boolean​ sugar; ​
    private​ ​boolean​ milk;
    TeaTwo(TeaBuilder teaBuilder){ ​
        this​.sugar = teaBuilder.sugar;
​        this​.milk = teaBuilder.milk; 
    }
​    static​ ​class​ ​TeaBuilder​{ ​
        private​ ​boolean​ sugar; ​
        private​ ​boolean​ milk;
        TeaBuilder(){}
​        public​ TeaBuilder ​setSugar​(​boolean​ sugar){ ​
            this​.sugar = sugar;
​            return this;​ 
        }
​        public​ TeaBuilder ​setMilk​(​boolean​ milk){ ​
            this​.milk = milk;
​            return this;​
        }
​        public​ TeaTwo ​build​(){
​            return​ ​new​ TeaTwo(​this​); 
        }
    } 
}
```
The builder is then used as follows:
```java
TeaTwo teaTwo = ​new TeaTwo.TeaBuilder().setSugar(​true​).setMilk(​true​).build();
```
[Build URI](Android-lesson2.md##Implict\nIntent)

## static nested classes
By declaring a nested class as static, it is known as a ​static nested class.

* It can only access static variables and methods in the outer class.
* It can be instantiated without an instance of the outer class.

A static nested class behaves like a top-level class and is a way to organize classes that are used only by some other classes.

[Nested Interface](https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html) & [Anonymous Classes](https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html)

```java - class1
public​ ​class​ ​SomeClassExample3​ {
​    interface​ ​MyInterface​{
​       void​ ​printSomething​(); 
    }

​    int​ a;

    SomeClassExample3(){
        a = ​10​; 
    }

​    public​ ​void​ ​display​(MyInterface myInterface){                           
        myInterface.printSomething();
    }
}
```
and outer class example
```java
public​ ​class​ ​OuterClassExample3​ { 
    SomeClassExample3 someClassExample3;
    OuterClassExample3(){
        someClassExample3 = ​new​ SomeClassExample3(); 
    }
​    public​ ​void​ ​callMe​(){
        someClassExample3.display( ​new​ InnerClass()); 
    }
​   class​ ​InnerClass​ ​implements​ ​SomeClassExample3​.​MyInterface​{ ​         
        @Override
​        public​ ​void​ ​printSomething​(){
            System.out.println(​"Hello"​); 
        }
    } 
}
```

A lot of classes in Android is implemented like this:
For example: [SharedPreferences.Editor](Android-lesson2.md###Data\npersistence\nwith\nSharedPereferences)

## static nested classes
By declaring a nested class as static, it is known as a static nested class.
- It can only access static variables and methods in the outer class.
- It can be instantiated without an instance of the outer class.
A static nested class behaves like a top-level class and is a way to organize classes that are used only by some other classes.

One reason for having a static nested class is to have a model class to store data.

## Singleton Design pattern
- Making the constructor private
- The sole instance is stored in a private static variable
- Using a static factory method to return an instance

```java
public class Singleton{
    private static Singleton singleton;
    private Singleton(){
         //any tasks you need to do here
    }
    public Singleton getInstance(){
        if(singleton == null){
            singleton = new Singleton();
}
        return singleton;
     }
     //other methods in your class
}
```

[Database](Android-lesson4.md##\nCreate\nConstructor\nfor\ndatabase)