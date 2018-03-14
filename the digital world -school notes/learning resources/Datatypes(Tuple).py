# -*- coding: utf-8 -*-
"""
Created on Tue Mar 14 09:16:54 2017

@author: Lim Jie Hong
"""

#########################################################
""" COLLECTION DATA TYPES (Tuple) """
#########################################################
"""Accesssing Values from Tuple"""
tup1 = (1,2,3,4,5,6)
print tup1[1]       #Should get 2
print tup1[0:3]     #Should get range (1,2,3)  **output is a type 'tuple'**
print tup1[0:4:2]   #Should get range (1,3)    **output is a type 'tuple'**
#########################################################
"""Updating Values from Tuple"""
tup1 = (1,2,3)
tup2 = (4,5,6)
tup3 = tup1 + tup2
print tup3          #Should get (1, 2, 3, 4, 5, 6) **output is a type 'tuple'**
#########################################################
"""Deleting Values from Tuple"""
tup1 = ('Physics', 'Chemistry', 'Math', 'Python')
del tup1
"""Cannot call tup1 anymore"""
"""tup1 is not defined anymore"""
#########################################################
"""Basic Tuple Operation"""
#########################################################
"""len(tuple): Get length of tuple"""
tup1 = (1,2,3,4,5,6)
print len(tup1)         #Should get value 6
#########################################################
"""tuple1 +tuple 2: Updating value from Tuple"""
tup1 = (1,2,3)
tup2 = (4,5,6)
print tup1 + tup2       #Should get (1, 2, 3, 4, 5, 6)
#########################################################
"""tuple*n: Repitition of Values"""
tup1 = ('Chicken!')
print tup1*3            #Should get Chicken!Chicken!Chicken! **type string**
tup1 = ('Chicken!',)
print tup1*3            #Should get ('Chicken!', 'Chicken!', 'Chicken!') **type tuple**
"Take note of what the corner does"
#########################################################
"""x in tuple: Check if x is in tuple, gives either True or False"""
tup1 = ('Panda','Food','Sleep')
print 'Sleep' in tup1   #Should get True
print 'Work' in tup1    #Should get False
#########################################################
"""for x in tuple: assign values in tuple as x(Loop/Iteration)"""
tup1 = ('Panda','Food','Sleep')
for x in tup1:
    print x             #Should get 'Panda' 'Food' 'Sleep'
"""Take note x values changes everytime loop begins => x cannot be 'Panda' 'Food' 'Sleep' at the same time"""
#########################################################
"""max(tuple): Returns item from the tuple with max value."""
tup1 = (1,2,300,4,5,6)
print max(tup1)         #Should get 300
tup1 = ('Panda','Food','Sleep')
print max(tup1)         #Should get 'Sleep' **Basically for Strings its alphabetical order**
#########################################################	
"""min(tuple): Returns item from the tuple with min value."""
tup1 = (-111,2,300,4,5,6)
print min(tup1)         #Should get -111
tup1 = ('Panda','Food','Sleep')
print min(tup1)         #Should get 'Food' **Basically for Strings its alphabetical order**
#########################################################
"""tuple(seq): Converts a list into tuple"""
seq = [1,2,3,4,5,6]
tup1 = tuple(seq)
print tup1              #Should get (1, 2, 3, 4, 5, 6)
#########################################################





















