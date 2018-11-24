# Question1
We have a pyramid like this. what is the best path to go from the bottom to the top. each time we can only go to left or right.
![pyramid_shortest_path.png](Images/pyramid_shortest_path2.png)


## Greedy approach, may not be the best answer.
At every decision, we choose the next best possible answer.
![pyramid_shortest_path.png](Images/pyramid_shortest_path1.png)

We can either get 21 or 24.

## DP
add up the bottom min{left, right} to the top, do like this all the way to the top.
![pyramid_shortest_path.png](Images/pyramid_shortest_path3.png)

Similar algorithms [Viterbi decode](https://en.wikipedia.org/wiki/Viterbi_decoder)
