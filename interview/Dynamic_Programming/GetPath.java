package com.example.pset2a;


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

