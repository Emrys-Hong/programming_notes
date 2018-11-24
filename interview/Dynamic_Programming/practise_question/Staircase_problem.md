# staircase problem
This problem is an addition to the count change problem
Problem:
you have n step staircase, you can go up each time by some steps, the step are defined in Array `steps` = [1, 3, 5, ..] times.

hint: if you can only go up [1,2] time, the number is a fibonacci sequence.

the bottom up aproach
```python
def num_ways_X(n, steps):
    if n==0: return 1

    nums = new int[n+1]
    nums[0] = 1
    for i from 1 up to n:
        total = 0
        for each j in steps:
            if i-j>0:
                total += nums[i-j]
        nums[i] = total
    return nums[n]
```
the algorithm should only take up O(n*len(step)) time.

normal recursion approach
```python
def num_ways_X(n, steps):
    if n==0: return 1

    total = 0
    
    for each j in steps:
        if i-j>0:
            total += nums[i-j]
    return nums[n]
```
This should take exponential time.
