package com.example.pset2a;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Permutation {
    private final String in;
    private ArrayList<String> a = new ArrayList<String>();
    // additional attribute if needed
    LinkedList<Character> array1 = new LinkedList<>();
    LinkedList<Character> array2 = new LinkedList<>();
    Permutation(final String str){
        in = str;
        // additional initialization if needed

        this.array1.add(in.charAt(0));

        for(int i=1; i<str.length(); i++) {
            array2.add(in.charAt(i));
        }

    }

    public void permute(){

        // produce the permuted sequence of 'in' and store in 'a', recursively
        if (this.a.size() == 0) {

            this.a.add(Character.toString(array1.get(0)));
            this.permute();

        } else if(array2.size() == 0) {
            ;
        } else {
            char del = array2.pop();
            Iterator<String> iter = this.a.iterator();
            ArrayList<String> replaceA = new ArrayList<>();

            while (iter.hasNext()) {
                String s = iter.next();
                for (int k=0; k<=s.length(); k++) {

                    String newS = s.substring(0, k) + del + s.substring(k, s.length());
                    replaceA.add(newS);

                }
            }
            this.a = replaceA;
            array1.add(del);
            this.permute();
        }


    }

    public ArrayList<String> getA(){
        return a;
    }
}
