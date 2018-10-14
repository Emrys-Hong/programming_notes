#this code is to solve give a number n, to give all the possible combinations in the given list
#my analysis is that if build every possible list, the computational time becomes intractable, as the computational time will increase exponentially with the # of items in the list
#if n is small enough then i will have enough time
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