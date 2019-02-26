package Week5;
import java.util.ArrayList;
import java.util.List;

/**
 * A Stack is a mutable object representing a last-in-first-out
 * stack of elements (of an arbitrary type E).  
 * Elements can be pushed onto the stack, and then popped off 
 * in the reverse order that they were pushed.
 * A Stack can hold an arbitrary number of elements.
 */
public class Stack<E> {
    // Stack is a *generic* class, which means it takes a type parameter.
    // The type parameter E must be filled in with an object type 
    // when using this class: e.g. Stack<String>, Stack<Double>, 
    // or Stack<List<Integer>>.  From Stack's point of view, however, 
    // the element type is just E.
    
    private final List<E> elems = new ArrayList<E>();
    // elems contains the elements in the stack, 
    // in order from oldest pushed (elems[0]) to 
    //          to the latest item pushed, and the 
    //           next to be popped (elems[size-1]).
    // If elems.size == 0, then the stack is empty.
    
    /**
     * Make a Stack, initially empty.
     */
    public Stack() {
        // Why isn't anything initialized here?
    }
    
    /**
     * Modifies this stack by pushing an element onto it.
     * @param e element to push on top
     * the number of elements in elems is incremented by one
     */
    public void push(E e) {
        elems.add(e);
    }
    
    /**
     * Modifies this stack by popping off the top element.
     * Requires: stack is not empty, i.e. size() > 0.
     * @return element on top of stack
     */
    public E pop() {
        final E e = elems.get(elems.size()-1);
        elems.remove(elems.size()-1);
        return e;
    }
    
    /**
     * @return number of elements in the stack
     */
    public int size() {
        return elems.size();
    }
}
