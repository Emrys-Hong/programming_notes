## how many ways can you decode the message
if we map a -> 1, b -> 2, ... z -> 26. how many ways are there for us to decode this problem given a string.

e.g. we are give "11", it can be decoded as "aa" or "k"

The algo should run in O(n) time.

1. two case:
- smaller than 26
- the first value start with 0

solution
```python
def num_ways_dp(data):
    memo = new int[data.length + 1] # initialize to nulls
    return helper_dp(data, data.length, memo)

def helper_dp(data, k, memo):
    if k == 0: # first case
        return 1
    s = data.length - k
    if data[s] == '0': # second case
        return 0
    if memo[k] != null:
        return memo[k]

    result = helper_Dp(data, k-1, memo)
    if k>=2 and int(data[s:s+2]) <= 26:
        result += helper_dp(data, k-2, memo)
    memo[k] = result
    return result
```