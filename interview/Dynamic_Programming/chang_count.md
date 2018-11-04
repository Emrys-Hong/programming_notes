## problems in common:
you have a function that adds up to a certain amount
you have some choices from a list, they can be reused or not reused.
## strategy
sort the give list first, and try small first, if it exceeds then ignore it.

## change count
find change adding up to a certain amount
this code is to solve give a number n, to give all the possible combinations in the given list
my analysis is that if build every possible list, the computational time becomes intractable, as the computational time will increase exponentially with the # of items in the list
if n is small enough then i will have enough time
```python
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


#below is another function
def all_combinations(total_list):
    mylist = [[]]
    for i in total_list:
        mylist_temp = deepcopy(mylist)
        for j in mylist_temp:
            j.append(i)
        mylist += mylist_temp
    return mylist
def list_filter(mylist,n):
    return [i for i in mylist if sum(i) == n]


#
testlist = [1,2,3,4,5,6,7,8,9,10,1,2,3,3,4,5,6,76,90,23,43,56,4,34,3]
print(recursion(testlist,10))
print(list_filter(all_combinations(testlist),10))
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