## problems in common:
1. for each element we need to make two decisions, include that in the answer or not.
2. using memoization to improve speed.


## change count
find change adding up to a certain amount
this code is to give a array A, and int x, to give all the possible subset in the given array A that adds up to x.

suppose you now have a number of choice of coins [1,2,5,10,20,50,100] if give you a number n, try to give all the combination of change that you can give

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