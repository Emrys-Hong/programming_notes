# ISTD Info Sys programming week4

## abstract class
only abstract method can be in abstract class. 

this cant be instantiated. cannot use new operator.

Practical advantage: Generic Programming.

```java
public class TestGeoObject {
	public static boolean equalArea(GeometricObject o1, GeometricObject o2){
		return o1.getArea() == o2.getArea();
	}
	
	public static void main (String[] args){
		Circle c = new Circle();
		Rect r = new Rect();
		System.out.println( equalArea(r,c));
	}

}
```
In this example, GeoObject have the function getArea() but it is not implemented, 

so when executing the function, it will go down to find the correct implementation in the sub class. 
Therefore you can compare the area between Rectangle and Circle.

for functions: it will consider the actual type first and then go up to the super class to find functions.

for data field: it will consider the declared type only.

one example that why we use abstract class
```java
// Fruit.java
public abstract class Fruit {
    public void shape() {
        System.out.println("Fruit have no shape");
    }

    public abstract void weight();
}

class Apple extends Fruit {
    public void shape() {
        System.out.println("Apple's shape is heart shape");
    }

    public void weight(){
        System.out.println("the apple have no weight");
    }
}
// Test.java
public class Main {
    public static void main(String[] args) {
        Fruit a = new Apple();
        a.shape();
        a.weight();
    }
}
```
output for a.shape() ==> apple's shape is heart shape, this means that if the super class have that function, then java can see how it is override.

output for a.weight() ==> Error if Fruit does not have that function.

so it must be implemented in the super class, that is why we need to use abstract class.
### Questions
1. the sub abstarct class do not to implement all the method in the super class. True
2. abstract class can define its constructors. True
3. abstract class can inherit from a concrete class. True
4. abstract class can be used as a datatype. True.
5. abstract class can have datafield. True
6. class cannot modify the visiblity of the super class. True

## interface
it is like a adjective.

all the methods are public abstract.

all the datafield is ```public static final```. (these modifiers are ok to be omitted.)

there are no constructors.

## java Framework
![javaFramework](https://github.com/Emrys-Hong/programming_notes/blob/master/java/Info_to_Sys_notes/JavaCollectionFramework.png)

## comparable
java definition, this is a generic interface, "E" is replaced by a datatype.

Classes Integer, String, Date all implement Comparable, thus they are comparable
```java
public interface Comparable<E> {
    public abstract int compareTo(E o);
}
```
example
```java
class Circle extends GeometricObject implements Comparable<Circle>{
	private double radius = 1;
	Circle() {
	}
	Circle (double radius) {
		this.radius = radius;
	}
	public int compareTo(Circle c){
		if (this.radius > c.radius) 
			return 1;
		else if (this.radius == c.radius) 
			return 0;
		else
			return -1;
	}
}

// can use the following way to sort
Collections.sort(l); // l is an ArrayList
```
this is used for in class comparasion, contrast to Comparator.

## comparator
this provides additional way of ordering.
```java
public class IntegerAbsComparator implements Comparator<Integer> {
	public int compare(Integer a, Integer b) {
		if (Math.abs(a) > Math.abs(b)) 
			return 1;
		else if (Math.abs(a) == Math.abs(b))
			return 0;
		else 
			return -1;
	}
	
}

// can use the following way to sort 
Collections.sort(l, new IntegerAbsComparator());
```

## Array
the same concept as python list
```java
public class Array2D {   
	public static void main(String[] args) {     
		int [][] a = new int[4][6];     
		for (int i = 0; i < a.length; i++) {          
			for (int j=0; j< a[i].length; j++) {            
				a[i][j] = i+j;
			}    
		}
     }
}
```
use ``Arrays.deepToString(a)`` for printing.

## recommend reading

Effective Java by Josua Bloch.
Recommend to use generic type for more flexible behaviour.
