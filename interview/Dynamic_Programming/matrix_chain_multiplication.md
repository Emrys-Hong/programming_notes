### Question
You are given matrix A, ... X. each have their own size. you need to find which order to multiply them together will have the least computational time.

For example, you have A:(2,3), B:(3,6), C:(6,4), D(4,5), To calculate their result, you can follow the sequence ((AB)(CD)) or (((AB)C)D). and they will have different computation time.

### solution
1. initialize a square matrix T of size (len(numOfMatrix)), later only have of the matrix will be filled.
2. use the formula:
```python
T[i][j] = min{ T[i][k] + T[k][j] + matrixI.first + matrixI.second + matrixK.second) # add the second value to bind them together
```
we also note down the path along the way. 

for example:
from 1 to 4 the best path is ((1,2)(3,4))
3. When decode, we use the smallest value traced from the log to back decode.


### reference
[Tushar Roy dynamic programming series](https://www.youtube.com/watch?v=vgLJZMUfnsU&index=3&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr)