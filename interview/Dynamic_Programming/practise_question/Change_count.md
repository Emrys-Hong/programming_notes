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