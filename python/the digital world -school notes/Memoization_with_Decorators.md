this is taken from https://www.python-course.eu/python3_memoization.php

# Memoization with Function Decorators
```
def fib(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        return fib(n-1) + fib(n-2)
        
ef memoize(f):
    memo = {}
    def helper(x):
        if x not in memo:            
            memo[x] = f(x)
        return memo[x]
    return helper
    

def fib(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        return fib(n-1) + fib(n-2)

fib = memoize(fib)

print(fib(40))
```
or you can write your code like this
```
def memoize(f):
    memo = {}
    def helper(x):
        if x not in memo:            
            memo[x] = f(x)
        return memo[x]
    return helper
    
@memoize
def fib(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        return fib(n-1) + fib(n-2)

print(fib(40))
```

another option is to write the memo in a class
```class Memoize:

    def __init__(self, fn):
        self.fn = fn
        self.memo = {}

    def __call__(self, *args):
        if args not in self.memo:
	    self.memo[args] = self.fn(*args)
        return self.memo[args]

@Memoize
def fib(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        return fib(n-1) + fib(n-2)
```

### Our exercise is an old riddle, going back to 1612. The French Jesuit Claude-Gaspar Bachet phrased it. We have to weigh quantities (e.g. sugar or flour) from 1 to 40 pounds. What is the least number of weights that can be used on a balance scale to way any of these quantities. 

The first idea might be to use weights of 1, 2, 4, 8, 16 and 32 pounds. This is a minimal number, if we restrict ourself to put weights on one side and the stuff, e.g. the sugar, on the other side. But it is possible to put weights on both pans of the scale. Now, we need only four weights, i.e. 1, 3, 9, 27 

Write a Python function weigh(), which calculates the weights needed and their distribution on the pans to weigh any amount from 1 to 40.

```
def factors_set():
    factors_set = ( (i, j, k, l) for i in [-1, 0, 1] 
                          for j in [-1, 0, 1]
                          for k in [-1, 0, 1]
                          for l in [-1, 0, 1])
    for factor in factors_set:
        yield factor

def memoize(f):
    results = {}
    def helper(n):
        if n not in results:
            results[n] = f(n)
        return results[n]
    return helper

@memoize
def linear_combination(n):
    """ returns the tuple (i,j,k,l) satisfying
        n = i*1 + j*3 + k*9 + l*27      """
    weighs = (1,3,9,27)
      
    for factors in factors_set():
       sum = 0
       for i in range(len(factors)):
          sum += factors[i] * weighs[i]
       if sum == n:
          return factors
          
 ```
 With this, it is easy to write our function weigh().
 ```
 def weigh(pounds):
    weights = (1, 3, 9, 27)
    scalars = linear_combination(pounds)
    left = ""
    right = ""
    for i in range(len(scalars)):
        if scalars[i] == -1:
            left += str(weights[i]) + " "
	elif scalars[i] == 1:
            right += str(weights[i]) + " "
    return (left,right)

for i in [2, 3, 4, 7, 8, 9, 20, 40]:
	pans = weigh(i)
	print("Left  pan: " + str(i) + " plus " + pans[0])
	print("Right pan: " + pans[1] + "\n")
  ```
