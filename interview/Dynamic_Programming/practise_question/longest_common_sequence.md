### Question
Give two string, find their common subsequence, the subsequence may be not continuous. It is also known as the levenshtein distance.

For example: StringA="abcdef" and StringB="acbfdf", the longest sequence is "abdf" or "acdf".

### solution(overview)
1. initialize a matrix of size (len(StringA), len(StringB))
2. The 0th row and 0th column is all zeros.
3. assign each value in the matrix according to this:
```
if (StringA[i]==StringB[j]):
    matrix[i][j] = matrix[i-1][j-1] + 1
```
4. decode the value in the matrix from the right bottom corner and see how the value changes from right bottom corner to top left corner.

### complexity
Time complexity for this algorithm is O(len(StringA)*len(StringB)).

### reference
[2nd video from Tushar Roy dynamic programming series](https://www.youtube.com/watch?v=NnD96abizww&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=3&t=0s)