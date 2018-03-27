https://docs.scipy.org/doc/numpy-dev/user/quickstart.html

import numpy as np
np.array([],dtype=np.float32) # this create a numpy array

np.arange(start,stop,step).reshape(n1,n0) # create a numpy array
np.linspace(start,stop,num_points)

# + - * / are all applicable for numpy array
a = np.array([1,1,1])
a.itemsize # how much space one datatype occupy # output 4
a.size # how many items
a.shape # shape
a.ndim # what is the dimension
a.dtype # data type

np.zeros( (3,4) )
np.ones( (3,4) )

a.ravel() # same as flatten()
a.flatten()

a.min()
a.max()
a.sum(axis=1) # sum all the row together)

a.dot(b)

np.sqrt(a) # sqrt
np.std(a) # standard diviation
# slicing
a[1:2,3]

for i in a.flat:
  print(i)
  
np.hstack(a,b) # stack horizontally
np.vstack(a,b) # stack vertically
np.hsplit(a,3) # split horizontally
np.vsplit(a,3) # split horizontally

# if the input is the following
a = np.arange(12).reshape(3,4)
b = a > 4
print(b)
# array([[False,False,Flase,False],[False,True,True......])
a[b] = 100
print(a)
# array([0,1,2,3],[4,100,100,100],...])

# nditer
for x in np.nditer(a,order='C'): # this is printing in row order
    print(x)
    
# 0,1,2,3,4,5....

for x in np.nditer(a, order='F'):
    print(x)
    
# 0,4,8,1,5,9

for x in np.nditer(a, order='F', flags=['external_loop']):
    print(x)
# [0,4,8]
#[1,5,9]
.....

for x in np.nditer(a, order='F', flags=['readwrite']):
    x[...] = x**2
# change all the enties to square

for x,y in np.nditer([a,b]):
    print(x,y)
 # x and y must have the same colum dimension
 
