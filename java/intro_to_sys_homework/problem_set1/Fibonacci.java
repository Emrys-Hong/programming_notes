package com.example.libfibo;

public class Fibonacci {
    public static void main(String[] args){
        System.out.println("Hello");
        System.out.println(args[0]);
    }

    public static String fibonacci( int n ){
        int f1 = 0;
        int f2 = 1;

        String ans = f1+","+f2;

        for (int i=3; i<=n; i++) {
            int mysum = f1 + f2;
            f1 = f2;
            f2 = mysum;
            ans += ","+mysum;
        }
        // java is statically typed
        // int a = 1; int a = "3" ?

        return ans;
    }
}

