# DPLL algorithm involves backtracking. 
using dynamic algorithms: 
copied from [JiaWeikhong](https://github.com/jiaweikhong/Term4_2D).
more reference [kohJingyu](https://github.com/kohjingyu/Term4_2D).
SUTD ISTD term4 2d, sat solver using java.
time manage to solve the best case for Unsat large, around 8s on Mac.

This is the rough schmetics for the 2D.

```
solver(clauses, env):
  case 1: contains {}, return None
  case 2: contains nothing, return env
  sort out to get the smallest clauses, using clause.size.
  set one random literal ```litchoosen``` in that clauses to be true. using clause ```substitue``` method.
  set the env in that clause to be true. newE = environment.set()
  output = f(clauses, env) // recursion here
  
  case 3: 
    if output == null and the value to that literal in that env is true:
      newE = environment.setFalse(literal)
      return solver(clauses, newE) // if it is true, we can also set it to false, backtracking here
    else output == null and the value to that literal in that env is False:
      return null
    
