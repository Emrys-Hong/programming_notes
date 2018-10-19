from helper import maze
from helper import mazeIO
import sys
#the deque class supports pops from both ends
from collections import deque 

class GridSquare:
    # Helper class to keep track of tiles and their parents
    def __init__(self, square, parent):
         self.square = square
         self.parent = parent

### A class for solving dank mazes ###

class MazeSolver:
    #Initializes the solver with the maze to solve
    #The maze class contains (see maze.py):
        # 1) matrix: the matrix of characters ('W', 'O', 'B', or 'E') 
        #            representing the maze
        # 2) start: the starting square as [row, column]
        # 3) end: the ending square as [row, column]
    def __init__(self, maze):
        self.maze = maze

    #Solves a maze.
    #search_type can be either DFS or BFS,
    #depending on whether you want the maze solved
    #using depth first search or breadth first search,
    #respectively.
    #
    #Returns a path through the maze as a list of [row, column]
    #squares where path[0] = maze.start and
    #path[len(path)-1] = maze.end
    #For every square i, path[i] should be adjacent to
    #path[i+1] and maze.matrix[i] should not be 'W'
    #
    #Also returns all the nodes expanded as a [row, column]
    #list.  These need not be in any particular order and
    #should include the nodes on the path.

    def solve_maze(self, search_type):
        
        if (search_type != "DFS" and search_type != "BFS"):
            print("Invalid search type")
            return [], []
        
        if (self.maze.start == []):
            print("Maze does not have starting square")
            return [], []

        if (self.maze.end == []):
            print("Maze does not have ending square")
            return [], []
        
        path = []
        expanded = []
        current = GridSquare(self.maze.start, self.maze.start)
        stack = [current]

        # Perform search until all required nodes are explored
        while len(stack) > 0 and current.square != self.maze.end:
            if search_type == "BFS":
                current = stack.pop(0)
            else:
                current = stack.pop()

            expanded.append(current.square)
            children = self.get_children(current)

            for child in children:
                val = self.maze.matrix[child.square[0]][child.square[1]]
                if val != 'S' and val != 'B':
                    stack.append(child)
                    if val != 'B' and val != 'E':
                        self.maze.matrix[child.square[0]][child.square[1]] = 'S'
        path = []

        if(current.square != self.maze.end):
            print("Search failed: no path exists.")
            return path, expanded

        # Add a point to the path
        while current.square != self.maze.start:
            path.append(current.square)
            current = current.parent

        path.append(current.square)
        path.reverse()
        print(path)

        return path, expanded

    def get_children(self, square):
        x = square.square[0]
        y = square.square[1]
        children = []

        left = self.maze.matrix[x - 1][y]
        if left != 'W':
            child = GridSquare([x - 1, y], square)
            children.append(child)
        right = self.maze.matrix[x + 1][y]
        if right != 'W':
            child = GridSquare([x+1, y], square)
            children.append(child)
        top = self.maze.matrix[x][y + 1]
        if top != 'W':
            child = GridSquare([x, y + 1], square)
            children.append(child)
        bottom = self.maze.matrix[x][y - 1]
        if bottom != 'W':
            child = GridSquare([x, y - 1], square)
            children.append(child)

        return children

#This main function will allow you to test your maze solver
#by printing your solution to a png image file or ascii text file.
#
#Usage: python maze_solver.py input_filename output_filename
#
#You must specify the input file name and the output file name. 
#The input should be a .png or .txt file in the form output by
#the mazeIO class.  See test_maze.png and many_paths.txt for examples.
#
#You also need to specify a search type:
#BFS: solves the maze using breadth first search
#DFS: solves the maze using depth first search
#

def main(argv):
    if (len(argv) < 4):
        print("Usage: python maze_solver.py maze_input_file output_file <BFS/DFS>")
        return
    infilename = argv[1]
    innameparts = infilename.split('.')
    if (len(innameparts) != 2 or (innameparts[1] != "png" \
                                  and innameparts[1] != "txt")):
        print("Must enter an input file name ending in .png or .txt")
        return
    outfilename = argv[2]
    outnameparts = outfilename.split('.')
    if (len(outnameparts) != 2 or (outnameparts[1] != "png" \
                                   and outnameparts[1] != "txt")):
        print("Must enter an output file name ending in .png or .txt")
        return
    if (argv[3] != "DFS" and argv[3] != "BFS"):
        print("Please enter valid search type.  Choose one of: BFS, DFS")
        return
    searchtype = argv[3]
    if (innameparts[1] == "png"):
        maze = mazeIO.pngIO.read_maze_from_png(infilename)
    else:
        maze = mazeIO.asciiIO.read_maze_from_ascii(infilename)
    solver = MazeSolver(maze)
    path, expanded = solver.solve_maze(searchtype)
    print("Length of path:", len(path), \
        "\nNumber of nodes expanded: ", len(expanded))
    if (outnameparts[1] == "png"):
        mazeIO.pngIO.write_visited_to_png(outfilename, maze, expanded, path)
    else:
        mazeIO.asciiIO.write_visited_to_ascii(outfilename, maze, expanded, path)

if __name__ == "__main__":
    main(sys.argv)

