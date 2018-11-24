## Negative numbers in a 2D array
give a sorted column-wise sorted array, give the number of negative numbers in a given array
The algorithm should take O(n+m) time, where n is the length of the row, and the m is the length of the column.

hint: using check the last number of each row and proceed to next row.
```python
def func(M, n, m):
    count = 0
    i = 0
    j = m-1
    while j>=0 and i<=0:
        if M[i][j] < 0:
            count += (j+1)
            i+=1
        else:
            j-=1
    return count
```