package com.example.pset2a;

import java.util.Arrays;

public class Palindrome {
    public static boolean isPalindrome (char[] S) {
        if(S.length == 1) {
            return true;
        } else if(S.length == 2 && S[0] == S[1]) {
            return true;
        } else if(S.length == 2 && S[0] != S[1]) {
            return false;
        } else {
            if(S[0] == S[S.length-1]) {
                return isPalindrome(Arrays.copyOfRange(S, 1, S.length-1));
            } else {
                return false;
            }
        }

    }
}
