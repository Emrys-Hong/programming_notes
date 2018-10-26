class Maze:
    def __init__(self, matrix, start=[], end=[]):
        self.matrix = matrix
        self.start = start
        self.end = end
        self.rows = len(matrix)
        self.cols = len(matrix[0])
