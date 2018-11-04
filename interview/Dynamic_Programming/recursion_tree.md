## problems in common:
you have a function that adds up to a certain amount
you have some choices from a list, they can be reused or not reused.
## strategy
sort the give list first, and try small first, if it exceeds then ignore it.

## change count
find change adding up to a certain amount
this code is to give a array A, and int x, to give all the possible subset in the given array A that adds up to x.

after using the memorized function, the computation time goes from 2^n to O(x*len(A)). as there will be x*len(A) possible times to compute these function.
[video explanation](https://www.youtube.com/watch?v=nqlNzOcnCfs)
```python
## we assume the arr is sorted 
## we consider the array from small to big
def count_sets_dp(arr, total):
    mem = {}
    return dp(arr, total, len(arr)-1, mem)

## classic answer using meomorized method to solve this function
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