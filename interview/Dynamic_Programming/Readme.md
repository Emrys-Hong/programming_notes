# Dynamic Programming

[CLRS solution website](http://sites.math.rutgers.edu/~ajl213/CLRS/CLRS.html); [CLRS solution github](https://github.com/gzc/CLRS/blob/master/C06-Heapsort/6.4.md);
## Table of content
- Memoization introduction --Compare the difference of time improvement of using memoization of DP on calculating fibonacci sequence with factorial


## Elements of dynamic programing
1. Optimal substructure

The solution to a problem can be obtained by solutions to sub-problems with no circular dependency. The result of subproblem A is not dependent on the subproblem of B. (if they do not share resources)

2. Overlapping subproblems

A recursive solution contains a "small" number of distinct sub-problems (repeated many times), so it can solve each subproblem just once.

## Steps of dynamic programming
1. Characterize the structure of an optimal solution. (Including Define sub-problems; What are the variables passed in the subsolution)
2. Recursively define the value of an optimal solution. (Think how subproblems can be combined together to get bigger problems)
3. Compute the value of an optimal solution, typically in a bottoms up fashion. (Guess part of the solution (initial condition), as well as the final answer)
4. Construct an optimal solution from computed information (Including: Recursion plus memoize & Algorithm run time analyzes)

## FAQ
1. recursion is dynamic programming?

No, we can use recursion to compute factorial but it is not dynamic programming. Calculating fibonacci sequence from a bottoms up way using for loop is also dynamic programming but it is not recursion.
However, most of the dynamic programming algorithms use recursion.


2. dynamic programming always uses memoization?

No, we can use bottoms-up way to do [cutting rod problem], however we do not need memoization.

The essence of dynamic programming:
Giving improvement to the time complexity by making smart decisions that will save the run time cost.