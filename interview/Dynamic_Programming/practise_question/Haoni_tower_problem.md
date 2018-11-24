## Hanoi Tower question
```python
'''Write a function called move_disks(n, fromTower, toTower, auxTower,sol)
to solve the Towers of Hanoi (Check http://en.wikipedia.org/wiki/Tower_of_Hanoi)
problem recursively. n is the number of disks, the next three parameters are labels of the
towers:
(a) from_tower: the tower from which you are supposed to move the disks from
(b) to_tower: the tower to which you are supposed to move the disks to
(c) aux_tower: an auxiliary tower to aid you in moving hte disks to complete the task
The last argument is a list to contain the solutions. The function should return a list of
strings. For example,
move_disks(1,‘A’,‘B’,‘C’,sol)
sol=[’Move disk 1 from A to B’]
9
move_disks(3,‘A’,‘B’,‘C’,sol)
[‘Move disk 1 from A to B’, ‘Move disk 2 from A to C’,
‘Move disk 1 from B to C’, ‘Move disk 3 from A to B’,
‘Move disk 1 from C to A’, ‘Move disk 2 from C to B’,
‘Move disk 1 from A to B’]'''
sol = []
def move_disks1(n, from_tower, to_tower, aux_tower, sol):
    
    if n == 1:
        string = 'Move disk {} from {} to {}'.format(n,from_tower,to_tower)
        sol.append(string)
    elif n > 1:
        move_disks(n-1,from_tower,aux_tower,to_tower,sol)
        sol.append('Move disk {} from {} to {}'.format(n,from_tower,to_tower))
        move_disks(n-1,aux_tower, to_tower, from_tower,sol)
        
    return sol
```