# -*- coding: utf-8 -*-
"""
Created on Mon Mar 13 16:25:00 2017

@author: Lim Jie Hong
"""

#########################################################
""" COLLECTION DATA TYPES (LIST) """
#########################################################
"""Calling Things in List"""
#Get Single Value
lst1 = [1,[2,3],[4,[5,6]]]
print lst1[0]           #Should get 1
print lst1[1][0]        #Should get 3
print lst1[2][1][1]     #Should get 6
""" lst[x] calls the x position in the lst."""
""" lst[x][y] calls a sublist in position x from lst and calls a the y position in the sublist"""
#Get Range of Value
lst1 = [1,2,3,4,5,6]
print lst1[0:3]         #Should get [1,2,3]
"""lst[x:y] makes a list out of the list from lst[x] to lst[y-1]"""
print lst1[0:3:2]       #Shuld get [1,3]
"""lst[x:y:z] makes a list out of the list from lst[x] to lst[y-1] with intervals of z"""
#########################################################
"""List Commands"""
"list.append(x) : Add an item to the end of the list."
lst = []
lst.append(1)
print lst       #Should get [1]
lst.append(2)
print lst       #Should get [1,2]
#########################################################
"list.extend(iterable): Extend the list by appending all the items from the iterable."
#Extend with List
lst1 = [1,2]
lst2 = [3,4]
lst1.extend(lst2)
print lst1      #Should get [1,2,3,4]

#Extend with Integer
"""lst1 = [1,2,3,4]"""
"""integer = 6789"""
"""lst1.extend(integer)"""
"""print lst1"""      #Error!

#Extend with String
lst1 = [1,2,3,4]
string = 'abcd'
lst1.extend(string)
print lst1      #Should get [1, 2, 3, 4, 'a', 'b', 'c', 'd']

#Extend with List of List
lst1 = [1,2,3,4]
lstoflst = [[1,2],[3,4]]
lst1.extend(lstoflst)
print lst1      #Should get [1, 2, 3, 4, [1, 2], [3, 4]]

#Extend with Dictionary
lst1 = [1,2,3,4]
dic = {'a':0,'b':0}
lst1.extend(dic)
print lst1      #Should get [1, 2, 3, 4, 'a','b'] *only keys of dictionary are put in*
#########################################################
"list.insert(i, x): Insert an item at a given position. The first argument is the index of the element before which to insert, so a.insert(0, x) inserts at the front of the list, and a.insert(len(a), x) is equivalent to a.append(x)."
lst1 = [1,2,3,4]
lst1.insert(1,'a')
print lst1      #Should get [1, 'a', 2, 3, 4]
#########################################################
"list.remove(x): Remove the first item from the list whose value is x. It is an error if there is no such item."
lst1 = [1,2,3,4]
lst1.remove(3)      #value in bracket is what u wanna remove exactly from the list
print lst1      #Should get [1,2,4]
#########################################################
"list.pop([i]): Remove the item at the given position in the list, and return it. If no index is specified, a.pop() removes and returns the last item in the list. (The square brackets around the i in the method signature denote that the parameter is optional, not that you should type square brackets at that position. You will see this notation frequently in the Python Library Reference.)"
lst1 = [1,2,3,4]
lst1.pop(1)
print lst1      #Should get [1, 3, 4]
#########################################################
"list.count(x): Return the number of times x appears in the list."
lst1 = [1,1,1,1]
print lst1.count(1)     #Should get 4   (there are four 1.)
#########################################################
"list.reverse(): Reverse the elements of the list in place."
lst1 = [[1,2],3,4]
lst1.reverse()
print lst1              #Should get [4, 3, [1, 2]]
#########################################################
"list.index(x): Return the index in the list of the first item whose value is x. It is an error if there is no such item"
lst1 = [1,2,3,4]
print lst1.index(4)     #Should get 3   (4 is in position 3 in lst1)