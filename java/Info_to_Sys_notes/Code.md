# Code

## array
fixed size

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

## iter
```java
Iterator<String> iter = this.a.iterator();

while (iter.hasNext()) {
    String s = iter.next();
}
```