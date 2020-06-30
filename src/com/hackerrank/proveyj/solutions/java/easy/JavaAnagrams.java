package com.hackerrank.proveyj.solutions.java.easy;

import java.util.Scanner;

public class JavaAnagrams {

    static boolean isAnagram(String a, String b) {
        a = a.toUpperCase();
        StringBuilder sb = new StringBuilder(b.toUpperCase());

        if(a.length()!=b.length())
            return false;

        for (char c : a.toUpperCase().toCharArray()) {
            int i = sb.indexOf(String.valueOf(c));
            if(i>=0 && i < sb.length())
                sb.deleteCharAt(i);
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}

