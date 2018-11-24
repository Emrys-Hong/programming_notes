## different combinations of count in an array

### problem description: 
given an Array A, find all the combinations of these array element
e.g. A = [1, 2] all subset: [null, null], [1, null], [null, 2], [1, 2]
```python
def all_subsets(given_array):
    subset = new int[given_array.length]
    helper(given_array, subset, 0)

def helper(given_array, subset, index):
    if index == array.length:
        print(subset)
    else:
        subset[index] = null
        helper(given_array, subset, index+1)
        subset[index] = given_array[index]
        helper(given_array, subset, index+1)
```