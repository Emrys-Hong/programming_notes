this is taken from https://www.python-course.eu/python3_lambda.php with some edition

# lambda function:
```
>>> sum = lambda x, y : x + y
>>> sum(3,4)
7
```

# map function
```
usecase:
r = map(func, seq)
```
e.g.
```
>>> def fahrenheit(T):
...     return ((float(9)/5)*T + 32)
... 
>>> def celsius(T):
...     return (float(5)/9)*(T-32)
... 
>>> temperatures = (36.5, 37, 37.5, 38, 39)
>>> F = map(fahrenheit, temperatures)
>>> C = map(celsius, F)
>>>
>>> temperatures_in_Fahrenheit = list(map(fahrenheit, temperatures))
>>> temperatures_in_Celsius = list(map(celsius, temperatures_in_Fahrenheit))
>>> print(temperatures_in_Fahrenheit)
[97.7, 98.60000000000001, 99.5, 100.4, 102.2]
>>> print(temperatures_in_Celsius)
[36.5, 37.00000000000001, 37.5, 38.00000000000001, 39.0]
```
map() can be applied to more than one list. The lists don't have to have the same length. map() will apply its lambda function to the elements of the argument lists, i.e. it first applies to the elements with the 0th index, then to the elements with the 1st index until the n-th index is reached: 
```>>> a = [1, 2, 3, 4]
>>> b = [17, 12, 11, 10]
>>> c = [-1, -4, 5, 9]
>>> list(map(lambda x, y : x+y, a, b))
[18, 14, 14, 14]
>>> list(map(lambda x, y, z : x+y+z, a, b, c))
[17, 10, 19, 23]
>>> list(map(lambda x, y, z : 2.5*x + 2*y - z, a, b, c))
[37.5, 33.0, 24.5, 21.0]
```
If one list has less elements than the others, map will stop, when the shortest list has been consumed:
```>>> a = [1, 2, 3]
>>> b = [17, 12, 11, 10]
>>> c = [-1, -4, 5, 9]
>>> 
>>> list(map(lambda x, y, z : 2.5*x + 2*y - z, a, b, c))
[37.5, 33.0, 24.5]
>>> 
```

# filter ( usage: filter(f,l) )
```>>> fibonacci = [0,1,1,2,3,5,8,13,21,34,55]
>>> odd_numbers = list(filter(lambda x: x % 2, fibonacci))
>>> print(odd_numbers)
[1, 1, 3, 5, 13, 21, 55]
>>> even_numbers = list(filter(lambda x: x % 2 == 0, fibonacci))
>>> print(even_numbers)
[0, 2, 8, 34]
>>> 
>>> 
>>> # or alternatively:
... 
>>> even_numbers = list(filter(lambda x: x % 2 -1, fibonacci))
>>> print(even_numbers)
[0, 2, 8, 34]
>>> 
```

# reduce 
  If seq = [ s1, s2, s3, ... , sn ], calling reduce(func, seq) works like this:
At first the first two elements of seq will be applied to func, i.e. func(s1,s2) The list on which reduce() works looks now like this: [ func(s1, s2), s3, ... , sn ]
In the next step func will be applied on the previous result and the third element of the list, i.e. func(func(s1, s2),s3)
The list looks like this now: [ func(func(s1, s2),s3), ... , sn ]
```
>>> import functools
>>> functools.reduce(lambda x,y: x+y, [47,11,42,13])
113
>>> 
```
