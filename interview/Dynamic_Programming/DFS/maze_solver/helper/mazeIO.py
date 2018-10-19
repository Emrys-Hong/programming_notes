from . import maze
import scipy.misc
import numpy as np

scaling = 4

class pngIO:
    @staticmethod
    def __get_raster(maze):
        
        #'W' always indicates black square
        #'S' or 'O' indicates a white square
        #'B' indicates start and 'E' indicates end
        raster = []
        for row in maze.matrix:
            rasterrow = []
            for entry in row:
                if (entry == 'W'):
                    pixel = [0, 0, 0]
                elif (entry == 'E'):
                    pixel = [0, 255, 0]
                elif (entry == 'B'):
                    pixel = [0, 0, 255]
                else:
                    pixel = [255, 255, 255]
                for i in range(scaling):
                    rasterrow.append(pixel)
            for i in range(scaling):
                raster.append(rasterrow)
        return raster

    @staticmethod
    def __add_points_to_raster(raster, maze, points, color):
        for point in points:
            if (maze.matrix[point[0]][point[1]] == 'W' or \
                maze.matrix[point[0]][point[1]] == 'B' or \
                maze.matrix[point[0]][point[1]] == 'E'):
                continue
            #overwrite all these pixels with the new color
            for i in range(point[0]*scaling, (point[0]+1)*scaling):
                for j in range(point[1]*scaling, (point[1]+1)*scaling):
                    raster[i][j] = color

    @staticmethod
    def __write_raster(filename, raster, maze):
        maze_img = np.array(raster)
        scipy.misc.imsave(filename, maze_img)

    @staticmethod
    def write_maze_to_png(filename, maze): 
        raster = pngIO.__get_raster(maze)
        pngIO.__write_raster(filename, raster, maze)

    @staticmethod
    def write_path_to_png(filename, maze, path):
        raster = pngIO.__get_raster(maze)
        red = [255, 0, 0]
        pngIO.__add_points_to_raster(raster, maze, path, red)
        pngIO.__write_raster(filename, raster, maze)
    
    @staticmethod
    def write_visited_to_png(filename, maze, visited, path):
        raster = pngIO.__get_raster(maze)
        purple = [255, 190, 255]
        pngIO.__add_points_to_raster(raster, maze, visited, purple)
        red = [255, 0, 0]
        pngIO.__add_points_to_raster(raster, maze, path, red)
        pngIO.__write_raster(filename, raster, maze)

            
    @staticmethod
    def read_maze_from_png(filename):
        raster = scipy.misc.imread(filename)
        ncols = raster.shape[0] // scaling
        nrows = raster.shape[1] // scaling

        matrix = []
        start = []
        end = []

        for i in range(0, ncols):
            currrow = []
            for j in range(0, nrows):
                pixel = raster[i * scaling, j * scaling]

                if pixel[0] == 0 and pixel[1] == 0 and pixel[2] == 0:
                    currrow.append("W")
                elif pixel[0] == 0 and pixel[1] == 0 and pixel[2] == 255:
                    currrow.append("B")
                    start = [i, j]
                elif pixel[0] == 0 and pixel[1] == 255 and pixel[2] == 0:
                    currrow.append("E")
                    end = [i, j]
                else:
                    currrow.append("O")

            matrix.append(currrow)

        return maze.Maze(matrix, start, end)

class asciiIO:
    @staticmethod
    def write_maze_to_ascii(filename, maze):
        
        outfile = open(filename, 'w')
        
        for row in maze.matrix:
            for entry in row:
                outfile.write(entry + " ")
            outfile.write("\n")
        outfile.close()
        
    @staticmethod
    def write_path_to_ascii(filename, maze, path):
        oufile = open(filename, 'w')
        rows = 0
        cols = 0
        for row in maze.matrix:
            for entry in row:
                
                if ([rows, cols] in path and (entry != 'W' and \
                                              entry != 'B' and \
                                              entry != 'E')):
                    outfile.write("X ")
                else:
                    outfile.write(entry + " ")
                cols += 1
            rows += 1
            outfile.write("\n")

        outfile.close()

    @staticmethod
    def write_visited_to_ascii(filename, maze, visited, path):
        outfile = open(filename, 'w')
        rows = 0
        cols = 0
        for row in maze.matrix:
            for entry in row:
                if ([rows, cols] in visited and (entry != 'W' and \
                                                 entry != 'B' and \
                                                 entry != 'E')):
                    if ([rows, cols] in path):
                        outfile.write("X ")
                    else:
                        outfile.write("V ")
                else:
                    if (entry == 'S' or entry == 'O'):
                        outfile.write("O ")
                    else:
                        outfile.write(entry + " ")
                cols += 1
            rows += 1
            cols = 0
            outfile.write("\n")

        outfile.close()

    @staticmethod
    def read_maze_from_ascii(filename):
        infile = open(filename, 'r')
        matrix = []
        start = []
        end = []
        for line in infile:
            row = line.split()
            col = -1
            for entry in row:
                col += 1
                if (entry == 'W' or entry == 'O'):
                    continue
                if (entry == 'B'):
                    start = [len(matrix), col]
                elif (entry == 'E'):
                    end = [len(matrix), col]
                else:
                    #anything else is interpreted as an open square
                    row[col] = 'O'
            matrix.append(row)

        return maze.Maze(matrix, start, end)

