
## finding path for Robot
![findPath](Images/findPath.png)
### problem:
A robot starts from the upper left corner of a grid (0,0) and attempts to move to spot (r,c). At every step, the robot can only move in two directions: right and down. Some spots are “blocked”, such that the robot cannot step on these positions. Design a static method getPath (inside a new class GetPath) to find a path for the robot to move from the top left (0,0) to a spot (r,c), recursively. The method returns true and the path, if such a path can be found, or false if such a path cannot be found.
The grid is represented as an integer 2-d array: a ‘0’ indicates the spot is non-blocked, a ‘1’ indicates the spot is blocked. The starting point (0,0) is always non-blocked.
In the method: public static boolean getPath (int r, int c, ArrayList<Point> path, final int [][] grid)
The arguments r, c specify the destination spot. The method returns true if a path can be found, returned in path. The grid is passed in as the last input argument grid.
### analyse:
try one solution first, if true, return true, if not true, call the other function until try all the combination.

the key is 
### code
```java
import java.util.ArrayList;

public class GetPath {
    public static boolean getPath (int r, int c, ArrayList<Point> path, final int [][] grid) {
        if (path.size() == 0) {
            path.add(new Point(0, 0));
            return GetPath.getPath(r, c, path, grid);
        } else {
            Point LastP = path.get(path.size()-1);
            // horizontal move
            if (LastP.x == c && LastP.y == r-1) {
                path.add(new Point(r, c));
                return true;
            } else if(LastP.x == c-1 && LastP.y == r) {
                path.add(new Point(r, c));
                return true;
            } else if (LastP.x < c && LastP.y <= r && (grid[LastP.y][LastP.x+1] == 0)) {
                path.add(new Point(LastP.y, LastP.x+1));
                if (GetPath.getPath(r, c, path, grid)) {
                    return true;
                } else {
                    path.remove(path.size()-1);
                    // second case
                    if(LastP.y < r && LastP.x <= c && (grid[LastP.y+1][LastP.x] == 0)) {
                        path.add(new Point(LastP.y+1, LastP.x));
                        if (GetPath.getPath(r, c, path, grid)) {
                            return true;
                        } else {
                            path.remove(path.size()-1);
                            return false;
                        }
                    } else {
                        return false;
                    }

                }
            } else if(LastP.y < r && LastP.x <= c && grid[LastP.y+1][LastP.x] == 0) {
                path.add(new Point(LastP.y+1, LastP.x));
                if (GetPath.getPath(r, c, path, grid)) {
                    return true;
                } else {
                    path.remove(path.size()-1);
                    // first case
                    if(LastP.x < c && LastP.y <= r && (grid[LastP.y][LastP.x+1] == 0)) {
                        path.add(new Point(LastP.y, LastP.x+1));
                        if (GetPath.getPath(r, c, path, grid)) {
                            return true;
                        } else {
                            path.remove(path.size()-1);
                            return false;
                        }
                    } else {
                        return false;
                    }
                }

            } else {
                return false;
            }

        }
    }
}

class Point {
    int x;
    int y;

    Point (int x, int y) {
        this.x=x;
        this.y=y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
```