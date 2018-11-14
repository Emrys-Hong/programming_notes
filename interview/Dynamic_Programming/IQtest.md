## 1. You are leading a software development team and your team is receiving many job assignments to finish.

Your team has a list of job assignments to finish, each requiring a certain amount of time to complete. Your team has exactly 3 members to work on these assignments. Each member can only work on one assignment at a time.  Once a member starts an assignment, s/he must complete that before taking up another assignment. Being effective and hard-working software developers, the team members do not require any break between the job assignments.
 
Can you write a static method to determine the smallest amount of time your team will need to finish all the job assignments, given the list of assignments to complete? 

## The difficulty is too understand that we need to allocate it to small first.
## solution 
```java
public static int computeTimeFinish(ArrayList<Integer> l) {
       // TODO: implement computeTimeFinish method
        ArrayList<Integer> time = new ArrayList<>(3);
        time.add(0);
        time.add(0);
        time.add(0);
        while (l.size()!=0) {
            int mintime = Collections.min(time);
            int index = time.indexOf(mintime);

            int nextJob = Collections.max(l);
            time.set(index, mintime+nextJob);
            l.remove(Collections.max(l));
        }
        return Collections.max(time);
    }
```

## Negative numbers in a 2D array
give a sorted column-wise sorted array, give the number of negative numbers in a given array
The algorithm should take O(n+m) time, where n is the length of the row, and the m is the length of the column.

hint: using check the last number of each row and proceed to next row.
```python
def func(M, n, m):
    count = 0
    i = 0
    j = m-1
    while j>=0 and i<=0:
        if M[i][j] < 0:
            count += (j+1)
            i+=1
        else:
            j-=1
    return count
```