package com.hackerrank.proveyj.solutions.java.easy;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class JavaList {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        List<Integer> list = Arrays.stream(sc.nextLine().split(" ")).
                map(s->Integer.valueOf(s)).
                collect(Collectors.toList());

        int m = sc.nextInt();
        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for(int i =0; i<m;i++) {
            if (sc.nextLine().trim().equals("Insert")) {
                int idx = sc.nextInt();
                int val = sc.nextInt();
                sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                list.add(idx,val);
            } else {
                int idx = sc.nextInt();
                sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                list.remove(idx);
            }
        }

        list.stream().map(x->x+" ").forEach(System.out::print);

    }
}
