## problems in common:
1. you have a function that adds up to a certain amount
1. you have some choices from a list, they can be reused or not reused.
1. these will normally let you list all the possibility, and therefore it will require to take O(2^n) time to solve it
2. using the memoized solution can relieve the solution.
## strategy
sort the give list first, and try small first, if it exceeds then ignore it.

## change count
find change adding up to a certain amount
this code is to give a array A, and int x, to give all the possible subset in the given array A that adds up to x.

after using the memoized function, the computation time goes from 2^n to O(x*len(A)). as there will be x*len(A) possible times to compute these function.
[video explanation](https://www.youtube.com/watch?v=nqlNzOcnCfs)
```python
## we assume the arr is sorted 
## we consider the array from small to big
def count_sets_dp(arr, total):
    mem = {}
    return dp(arr, total, len(arr)-1, mem)

## classic answer using meomoized method to solve this function
## we assume the array is sorted
def dp(arr, total, i, mem):
    key = str(total) + ':' + str(i)
    if key in mem:
        return mem[key]
    if total == 0:
        return 1 # can return an output of nothing
    else if total < 0:
        return 0
    else if i < 0:
        return 0
    else if total < arr[i]:
        to_return = dp(arr, total, i-1, mem)
    else:
        to_return = dp(arr, total, i-1, mem) + dp(arr, total-arr[i], i-1, mem)
    mem[key] = to_return
    return to_return

## my ans
from copy import deepcopy
def recursion(input_list,n):
    min_list = [item for item in input_list if item <= n]
    output_list = []
    if sum(min_list) < n:
        return False
    else:
        if n in min_list:
            output_list.append([n])
        for i in min_list:
            temp_list = deepcopy(min_list)
            temp_list.remove(i)
            if recursion(temp_list, n-i):
                for j in recursion(temp_list, n-i):
                    j.append(i)
                    output_list.append(j)
    return output_list
```
## change count
### problem description:
suppose you now have a number of choice of coins [1,2,5,10,20,50,100] if give you a number n, try to give all the combination of change that you can give
### solution
```python
def change(n, coins_available, coins_so_far):
    if sum(coins_so_far) == n:
        yield coins_so_far
    elif sum(coins_so_far) > n:
        pass
    elif coins_available == []:
        pass
    else:
        for c in change(n, coins_available[:], coins_so_far+[coins_available[0]]):
            yield c
        for c in change(n, coins_available[1:], coins_so_far):
            yield c

n = 7
coins = [1,2,4,8,16,32]
print(len([i for i in change(n, coins, [])]))
```

## different combinations of count in an array
### problem description: 
given an Array A, find all the combinations of these array element
e.g. A = [1, 2] all subset: [null, null], [1, null], [null, 2], [1, 2]
```python
def all_subsets(given_array):
    subset = new int[given_array.length]
    helper(given_array, subset, 0)

def helper(given_array, subset, index):
    if index == array.length:
        print(subset)
    else:
        subset[index] = null
        helper(given_array, subset, index+1)
        subset[index] = given_array[index]
        helper(given_array, subset, index+1)
```

## knapsack problem, have comparing after calculate the value
you have a bag of capacity C, and you have some items in you bag and they have some weights and values. try to maximize the amount of weights you have, return the amount of value you need to have

e.g. the items you have

Weight(kg) | 1| 2| 4| 2| 5
___________________________
Value      | 5| 3| 5| 3| 2

solution:
```python
arr[n][C] = undefined
def KS(n, C):
    if arr[n][C] != undefined:
        return arr[n][C]
    if n==0 or C==0:
        result = 0
    else if w[n] > C:
        result = KS(n-1, C)
    else:
        tmp1 = KS(n-1, C)
        tmp2 = V[n] + KS(n-1, C - w[n])
        result = max(tmp1, tmp2)
    arr[n][C] = result
    return result
```
run time analysis of this memoized program. O(nC). n is # of items and C is capacity.

## how many ways can you decode the message
if we map a -> 1, b -> 2, ... z -> 26. how many ways are there for us to decode this problem given a string.

e.g. we are give "11", it can be decoded as "aa" or "k"

The algo should run in O(n) time.

1. two case:
- smaller than 26
- the first value start with 0

solution
```python
def num_ways_dp(data):
    memo = new int[data.length + 1] # initialize to nulls
    return helper_dp(data, data.length, memo)

def helper_dp(data, k, memo):
    if k == 0: # first case
        return 1
    s = data.length - k
    if data[s] == '0': # second case
        return 0
    if memo[k] != null:
        return memo[k]

    result = helper_Dp(data, k-1, memo)
    if k>=2 and int(data[s:s+2]) <= 26:
        result += helper_dp(data, k-2, memo)
    memo[k] = result
    return result
```

## staircase problem
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