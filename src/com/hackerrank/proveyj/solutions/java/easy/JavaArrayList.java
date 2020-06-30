package com.hackerrank.proveyj.solutions.java.easy;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaArrayList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer>[] arrayLists = new ArrayList[n];
        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i <n; i++) {
            String line = sc.nextLine();
            arrayLists[i] = Arrays.stream(line.split(" ")).map(x->Integer.valueOf(x))
                    .collect(Collectors.toList());

        }

        n= sc.nextInt();
        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<n; i++) {
            String line = sc.nextLine();
            int[] xy = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            try {
                System.out.println(arrayLists[xy[0] - 1].get(xy[1]));
            }catch(Exception e){
                System.out.println("ERROR!");
            }
        }
    }
}
