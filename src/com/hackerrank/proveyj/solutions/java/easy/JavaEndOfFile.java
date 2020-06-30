package com.hackerrank.proveyj.solutions.java.easy;

import java.io.*;
import java.util.*;

public class JavaEndOfFile {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(str);
            if(str.contains("end-of-file")) {
                break;
            }
        }
    }
}
