# Code

## array
fixed size
```java
// copy only part of the array, equals to list[1:len(list)]
Arrays.copyOfRange(S, 1, S.length-1);
// copy the full array
int[] b = a.clone();
// fill array with a value
Arrays.fill(sIn2_array, 0);
// print the array
System.out.println(Arrays.toString(a));
```

## LinkedList

```get(int index)``` is O(n) (with n/4 steps on average)

```add(E element)``` is O(1)

```add(int index, E element)``` is O(n) (with n/4 steps on average), but O(1) when index = 0 <--- main 

benefit of LinkedList<E>
```remove(int index)``` is O(n) (with n/4 steps on average)

```Iterator.remove()``` is O(1). <--- main benefit of LinkedList<E>

### other methods
```LinkedList.getFirst()``` and ```LinkedList.getLast()```


## ArrayList
```get(int index)``` is O(1) <--- main benefit of ArrayList<E>

```add(E element)``` is O(1) amortized, but O(n) worst-case since the array must be resized and copied

```add(int index, E element)``` is O(n) (with n/2 steps on average)

```remove(int index)``` is O(n) (with n/2 steps on average)

```Iterator.remove()``` is O(n) (with n/2 steps on average)

```ListIterator.add(E element)``` is O(n) (with n/2 steps on average)

![common_operations](https://github.com/Emrys-Hong/programming_notes/blob/master/java/Info_to_Sys_notes/LinkedList_operations.png)

## Collections [reference here](http://www.ntu.edu.sg/home/ehchua/programming/java/j5c_collection.html#zz-8.2)
```java
// sorting
Collections.sort()
// binary search. the list must be sorted
Collections.binarySearch()
// min and max
Collections.max()
Collections.min()
```
## Iter
```java
Iterator<String> iter = this.a.iterator();

while (iter.hasNext()) {
    String s = iter.next();
}
```

## String operations
![String_operations](https://github.com/Emrys-Hong/programming_notes/blob/master/java/Info_to_Sys_notes/String_operation.png)
### extra
```java
stringA.toCharArray();
stringA.indexOf('substring');
stringA.contains('substring');
```

## Character toString
```java
Character.toString(array1.get(0));
```

## down casting
Object o = getSomeObject(),
String s = (String) o; // this is allowed because o could reference a String

## convert array, ArrayList, LinkedList types
```java
// LinkedList to array
String[] array = linkedlist.toArray(new String[linkedlist.size()]);
// array to LinkedList
LinkedList<Integer> w = new LinkedList<Integer>(Arrays.asList(t));

// array to ArrayList
ArrayList<Integer> w = new ArrayList<Integer>(Arrays.asList(t));
// ArrayList to array
// stockList is a arraylist
String[] stockArr = new String[stockList.size()];
stockArr = stockList.toArray(stockArr);
```

## Hashmap
```java
HashMap<String(key), Integer(value)> map = new HashMap<>();
map.put(value, idx);
map.get(key);
map.containsKey();
map.containsValue();
map.entrySet(); // dict.items()
map.keySet(); // dict.keys()
```

## Character
```java
Character.isLetter(c)
Character.isLowerCase(c)
```

## instance
```
instanceof tests whether the object reference on the left-hand side (LHS) is an instance of the type on the right-hand side (RHS) or some subtype.

getClass() == ... tests whether the types are identical.
```

## System time
```java
long start = new System.nanoTime();
```