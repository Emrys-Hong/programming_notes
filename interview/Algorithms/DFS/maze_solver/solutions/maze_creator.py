from helper import maze as maze_class
from helper import mazeIO
import random
import sys


class GridSquare:
    def __init__(self, square, wall):
        
         self.square = square
         self.wall = wall

### A class for creating dank mazes ###
class MazeCreator:

    #Constructs a maze creator, which
    #just stores the size of the maze
    def __init__(self, rows, cols):
        self.rows = rows
        self.cols = cols

    #You will return a maze object, maze, from this function such that:
    # 1) maze.matrix is size rows X cols
    # 2) maze.end = end and maze.matrix[end[0]][end[1]] = 'E'
    # 3) maze.start = some square you pick and 
    #    maze.matrix[maze.start[0]][maze.start[1]] = 'B'
    # 4) There is an open path from start to end, marked out by 'O's
    #    and the maze is an interesting maze created using DFS
    
    #Input: end: the goal square as [row, column]
    def create_maze(self, end):

        #this creates a rows X cols matrix of all walls
        matrix = [['W' for i in range(self.cols)] \
                   for j in range(self.rows)]        
        
        #this creates a new maze (see maze.py)
        #the maze class stores:
        # 1) the matrix we have just created
        # 2) the starting square, which is the empty list right now
        # 3) the ending square, which was passed into the function
        #you can set the starting square using
        maze = maze_class.Maze(matrix, [], end)

        curr = GridSquare(end, end)
        stack = [curr]
        opensquares = []

        while len(stack) > 0:
            n = []
            curr = stack.pop()
            maze.matrix[curr.square[0]][curr.square[1]] = 'O'
            maze.matrix[curr.wall[0]][curr.wall[1]] = 'O'
            opensquares.append(curr.square)
            opensquares.append(curr.wall)

            children = self.get_children(maze, curr)

            for child in children:
                if(maze.matrix[child.square[0]][child.square[1]] != 'O' and maze.matrix[child.square[0]][child.square[1]] != 'S'):
                    stack.append(child)
                    maze.matrix[child.square[0]][child.square[1]] = 'S' # Visited

        maze.start = opensquares[random.randrange(len(opensquares) - 1)]
        maze.matrix[maze.start[0]][maze.start[1]] = 'B'
        maze.matrix[end[0]][end[1]] = 'E'
        
        return maze

    def get_children(self, maze, curr):
        result = []
        children = []
        walls = []
        x = curr.square[0]
        y = curr.square[1]

        if x < maze.cols - 3:
            # Add right square
            walls.append([x + 1, y])
            children.append([x + 2, y])
        if x > 2:
            # Add left square
            walls.append([x - 1, y])
            children.append([x - 2, y])
        if y < maze.rows - 3:
            # Add top square
            walls.append([x, y + 1])
            children.append([x, y + 2])
        if y > 2:
            # Add bottom square
            walls.append([x, y - 1])
            children.append([x, y - 2])

        while len(children) > 0:
            index = random.randrange(len(children))
            child = GridSquare(children[index], walls[index])

            children.pop(index)
            walls.pop(index)

            result.append(child)

        return result

#This main function will allow you to test your maze creator
#by printing your maze to a png image file or ascii text file.
#
#Usage: maze_creator rows cols output_filename
#
#You must specify the size of the maze (rows X cols) and the
#output file name.  This name should end in .png for a png image
#and .txt for an ascii file.  

def main(argv):
    if (len(argv) < 4):
        print("Usage: python maze_creator.py rows cols output_filename<.txt/.png>")
        return

    rows = int(argv[1])
    cols = int(argv[2])
    nameparts = argv[3].split('.')
    if (len(nameparts) != 2 or \
        (nameparts[1] != "txt" and nameparts[1] != "png")):
        print("You must specify either ASCII output (.txt filename) or PNG output (.png filename)")
        return
    creator = MazeCreator(rows, cols)
    maze = creator.create_maze([random.randint(1, rows-2), \
                                random.randint(1, cols-2)])
    if (nameparts[1] == "txt"):
        mazeIO.asciiIO.write_maze_to_ascii(argv[3], maze)
    else:
        mazeIO.pngIO.write_maze_to_png(argv[3], maze)

if __name__ == "__main__":
    main(sys.argv)
