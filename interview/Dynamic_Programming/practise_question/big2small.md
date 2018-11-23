# Big to small questions
These question will usually contains a complicated problem with a large size which is composed of small
problem of small size.
The key to get through these problems is to
 * find out how case n-1 is progressed to case n, and of course find the base case
 * find what information changed or passed to the next case, from case n-1 progressed to case n.

```java
/**
 * The first problem is a permutation problem.
 * where it let you find or permutations of characters of a string.
 * it should always be n! complexity
 * how it progresses: we take a string, and insert the character to their slots one by one.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Permutation {
    private final String in;
    private ArrayList<String> a = new ArrayList<String>();
    // additional attribute if needed
    LinkedList<Character> array1 = new LinkedList<>();
    LinkedList<Character> array2 = new LinkedList<>();
    Permutation(final String str){
        in = str;
        // additional initialization if needed

        this.array1.add(in.charAt(0));

        for(int i=1; i<str.length(); i++) {
            array2.add(in.charAt(i));
        }
    }

    public void permute(){

        // produce the permuted sequence of 'in' and store in 'a', recursively
        if (this.a.size() == 0) {

            this.a.add(Character.toString(array1.get(0)));
            this.permute();

        } else if(array2.size() == 0) {
            ;
        } else {
            char del = array2.pop();
            Iterator<String> iter = this.a.iterator();
            ArrayList<String> replaceA = new ArrayList<>();

            while (iter.hasNext()) {
                String s = iter.next();
                for (int k=0; k<=s.length(); k++) {

                    String newS = s.substring(0, k) + del + s.substring(k, s.length());
                    replaceA.add(newS);

                }
            }
            this.a = replaceA;
            array1.add(del);
            this.permute();
        }
    }
    public ArrayList<String> getA(){
        return a;
    }
}
```
## Hanoi Tower question
```python
'''Write a function called move_disks(n, fromTower, toTower, auxTower,sol)
to solve the Towers of Hanoi (Check http://en.wikipedia.org/wiki/Tower_of_Hanoi)
problem recursively. n is the number of disks, the next three parameters are labels of the
towers:
(a) from_tower: the tower from which you are supposed to move the disks from
(b) to_tower: the tower to which you are supposed to move the disks to
(c) aux_tower: an auxiliary tower to aid you in moving hte disks to complete the task
The last argument is a list to contain the solutions. The function should return a list of
strings. For example,
move_disks(1,‘A’,‘B’,‘C’,sol)
sol=[’Move disk 1 from A to B’]
9
move_disks(3,‘A’,‘B’,‘C’,sol)
[‘Move disk 1 from A to B’, ‘Move disk 2 from A to C’,
‘Move disk 1 from B to C’, ‘Move disk 3 from A to B’,
‘Move disk 1 from C to A’, ‘Move disk 2 from C to B’,
‘Move disk 1 from A to B’]'''
sol = []
def move_disks1(n, from_tower, to_tower, aux_tower, sol):
    
    if n == 1:
        string = 'Move disk {} from {} to {}'.format(n,from_tower,to_tower)
        sol.append(string)
    elif n > 1:
        move_disks(n-1,from_tower,aux_tower,to_tower,sol)
        sol.append('Move disk {} from {} to {}'.format(n,from_tower,to_tower))
        move_disks(n-1,aux_tower, to_tower, from_tower,sol)
        
    return sol
```


## solving palindrome using recursion
```java
public class Palindrome {
    public static boolean isPalindrome (char[] S) {
        if(S.length == 1) {
            return true;
        } else if(S.length == 2 && S[0] == S[1]) {
            return true;
        } else if(S.length == 2 && S[0] != S[1]) {
            return false;
        } else {
            if(S[0] == S[S.length-1]) {
                return isPalindrome(Arrays.copyOfRange(S, 1, S.length-1));
            } else {
                return false;
            }
        }

    }
}
```