this is to indicate the object oriented programming

```my examples:
class Robot:
    pass
'''
if __name__ == "__main__":
    x = Robot()
    y = Robot()
    y2 = y
    print(y == y2)
    print(y == x)
'''
the answer is:
'''
True
False
'''


mydictionary:
class
class1.__dict__
for state machine
start_state =
class1.start()
class1.get_next_values(self,state,inp)
class1.transduce([list1])

super.__init__(no self here)
isinstance(object, classinfo)
hasattri(class,attribute_name)
dir(class)
```
# how to get the key of a specific value in the dictionary
```dictionary = {1:'a',2:'b'}
key = list(dictionary.keys())[list(dictionary.values()).index('b')]
>> key = 2
```
# how to sort the list by any order you like:
```if we have a list of objects, for example we have many employees and we want to sort the list according to their age

def agekey(object):
  return object.age
list = [employee1, employee2, ...]
sorted_list = sorted(list,key=agekey)
```
this is convert the number into a binary num
bin(num,2)
