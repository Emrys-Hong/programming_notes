from helper import maze
from helper import mazeIO
import sys
#the deque class supports pops from both ends
from collections import deque 


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

    # Solves a maze.
    # search_type can be either DFS or BFS,
    # depending on whether you want the maze solved
    # using depth first search or breadth first search,
    # respectively.
    # 
    # Returns a path through the maze as a list of [row, column]
    # squares where path[0] = maze.start and
    # path[len(path)-1] = maze.end
    # For every square i, path[i] should be adjacent to
    # path[i+1] and maze.matrix[i] should not be 'W'
    # 
    # Also returns all the nodes expanded as a [row, column]
    # list.  These need not be in any particular order and
    # should include the nodes on the path.

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

        #######################################
        #           YOUR CODE HERE            #
        #######################################

        # A value of 'B' in self.maze denotes the start point
        # 'E' denotes the end point.

        # Remember to check if search_type == "BFS" or search_type == "DFS", and run the appropriate algorithm!

        # Example: If the start point of the maze is x = 0, y = 0, and the end point is x = 2, y = 0
        # the path return will be of the form
        # [[0, 0], [1, 0], [2, 0]]

        # Expanded is a list of all squares explored.
        # In the above example, this may be something like 
        # [[0, 0], [1, 0], [2, 0], [1, 1], [1, 2]]
        # This always has to include the path as a subset!

        return path, expanded

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

