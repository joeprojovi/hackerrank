package com.hackerrank.proveyj.solutions.java.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class JavaStringCompare {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";


        List<String> list = new ArrayList<>();

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        smallest = s.substring(0,k);
        largest = s.substring(0,k);

        for (int i = 0; i+k <= s.toCharArray().length; i++) {
             String sbstr = s.substring(i,i+k);
             smallest = smallest.compareTo(sbstr)>0?sbstr:smallest;
             largest = largest.compareTo(sbstr)<0?sbstr:largest;
        }


        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
