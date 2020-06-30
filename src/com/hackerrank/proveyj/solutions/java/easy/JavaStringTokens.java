package com.hackerrank.proveyj.solutions.java.easy;

import java.io.*;
import java.util.*;

public class JavaStringTokens {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String trim = s.trim();
        if(!trim.isEmpty()) {
            String[] split = trim.split("[^a-zA-Z]+");
            System.out.println(split.length);
            for (String s1 : split) {
                System.out.println(s1);
            }
        }
        else
            System.out.println(trim.length());

        scan.close();
    }
}
