# Dynamic Programming

## Table of content
- Memoization introduction --Compare the difference of time improvement of using memoization of DP on calculating fibonacci sequence with factorial


## Elements of dynamic programing
1. Optimal substructure

The solution to a problem can be obtained by solutions to sub-problems with no circular dependency. The result of subproblem A is not dependent on the subproblem of B. (if they do not share resources)

2. Overlapping subproblems

A recursive solution contains a "small" number of distinct sub-problems (repeated many times), so it can solve each subproblem just once.

## Steps of dynamic programming
1. Define sub-problems
2. Guess part of the solution (initial condition), as well as the final answer
3. What are the variables passed in the subsolution
4. Think how subproblems can be combined togethe to get bigger problems
5. recurse plus memoize.
6. algorithm run time analyzes