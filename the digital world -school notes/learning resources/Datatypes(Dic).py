# -*- coding: utf-8 -*-
"""
Created on Mon Mar 13 22:54:16 2017

@author: Lim Jie Hong
"""

#########################################################
""" COLLECTION DATA TYPES (Dictionary) """
#########################################################
#Add values to dictionary
dict = {}
dict['key'] = 'values'
dict['Day'] = 22            #IntegerValues
dict['Month'] = 'Feb'       #StringValues
dict['Year'] = 1996.0       #FloatValues
print dict          #Should get {'Year': 1996.0, 'Day': 22, 'key': 'values', 'Month': 'Feb'}
"""Dictionary is not organized. Hence, dun worry that about the arrangement in dictionary."""
#########################################################
#Remove key and value from dictionary
dict = {'Year': 1996.0, 'Day': 22, 'key': 'values', 'Month': 'Feb'}
del dict['key']
print dict          #Should get {'Month': 'Feb', 'Day': 22, 'Year': 1996.0}
#########################################################
#Remove/Change value from dictionary
dict = {'Month': 'Feb', 'Day': 22, 'Year': 1996.0}
dict['Year'] = 0
print dict          #Should get {'Year': 0, 'Day': 22, 'Month': 'Feb'}
dict['Year'] = 1995.0
print dict          #Should get {'Year': 1995.0, 'Day': 22, 'Month': 'Feb'}  
#########################################################
#Check whether key is in dictionary and print value
dict = {'Month': 'Feb', 'Day': 22, 'Year': 1996.0}
for i in dict:
#    print i         #Should get 'Year', 'Day', 'Month'
    if i == 'Year':
        print dict[i]  #Should get 1996.0
        print i        #Should get 'Year'
#########################################################
"""Dictionary Commands"""
"cmp(dict1, dict2): Compares elements of both dict."
dict1 = {'Month': 'Feb', 'Day': 22, 'Year': 1996.0}
dict2 = {'Month': 'Mar', 'Day': 4, 'Year': 1995.0}
print cmp(dict1,dict2)      #returns 0 if both dictionaries are equal, -1 if dict1 < dict2 and 1 if dict1 > dic2.
##########################################################	
"len(dict): Gives the total length of the dictionary. This would be equal to the number of items in the dictionary."
dict1 = {'Month': 'Feb', 'Day': 22, 'Year': 1996.0}
print len(dict1)        #Should get 3
##########################################################	
"type(variable): Returns the type of the passed variable. If passed variable is dictionary, then it would return a dictionary type."
dict1 = {'Month': 'Feb', 'Day': 22, 'Year': 1996.0}
print type(dict1)   #<type 'dict'>
"str(dict): Produces a printable string representation of a dictionary"
z = str(dict1)
print type(z)       #<type 'dict'> to <type 'str'>
##########################################################	
"dict.clear(): Removes all elements of dictionary dict"
dict1 = {'Month': 'Feb', 'Day': 22, 'Year': 1996.0}
dict1.clear()
print dict1         #Should get {}
##########################################################
"dict.fromkeys(): Create a new dictionary with keys from seq and values set to value."
seq = ("Month", "Year" , "Days")
dict1 = dict1.fromkeys(seq)
print dict1        #Should get {'Year': None, 'Days': None, 'Month': None}
dict1 = dict1.fromkeys(seq,10)
print dict1        #Should get {'Year': 10, 'Days': 10, 'Month': 10}
##########################################################
"dict.get(key, default=None): For key key, returns value or default if key not in dictionary"
dict1 = {'Month': 'Feb', 'Day': 22, 'Year': 1996.0}
z =  dict1.get('Day')
print z            #Should get 22
##########################################################
"dict.has_key(key): Returns true if key in dictionary dict, false otherwise"
dict1 = {'Month': 'Feb', 'Day': 22, 'Year': 1996.0}
print dict1.has_key('Day')  #Should get True
##########################################################
"dict.items(): Returns a list of dict's (key, value) tuple pairs"
dict1 = {'Month': 'Feb', 'Day': 22, 'Year': 1996.0}
print dict1.items()         #Should get [('Year', 1996.0), ('Day', 22), ('Month', 'Feb')]
##########################################################	
"dict.keys(): Returns list of dictionary dict's keys"
dict1 = {'Month': 'Feb', 'Day': 22, 'Year': 1996.0}
print dict1.keys()          #Should get ['Year', 'Day', 'Month']
##########################################################
"dict.setdefault(key, default=None): Similar to get(), but will set dict[key]=default if key is not already in dict"
dict1 = {'Month': 'Feb', 'Day': 22, 'Year': 1996.0}
print dict1.setdefault('Month')     #Should get Feb
print dict1.setdefault('Decade',2)  #Should get 2
print dict1                         #Should get {'Year': 1996.0, 'Day': 22, 'Decade': 2, 'Month': 'Feb'}
"Functions adds another key to the dictionary along with a value"
##########################################################
"dict.update(dict2): Adds dictionary dict2's key-values pairs to dict"
dict1 = {'Month': 'Feb', 'Day': 22, 'Year': 1996.0}
dict2 = {'Months': 'Mar', 'Days': 4, 'Years': 1995.0}
dict1.update(dict2)
print dict1                 #Should get {'Years': 1995.0, 'Year': 1996.0, 'Months': 'Mar', 'Day': 22, 'Days': 4, 'Month': 'Feb'}
##########################################################
"dict.values(): Returns list of dictionary dict's values"
dict1 = {'Month': 'Feb', 'Day': 22, 'Year': 1996.0}
print dict1.values()        #Should get [1996.0, 22, 'Feb']
##########################################################








