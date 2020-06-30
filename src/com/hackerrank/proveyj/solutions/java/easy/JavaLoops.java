package com.hackerrank.proveyj.solutions.java.easy;

import java.util.*;
import java.io.*;

class JavaLoops{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            System.out.println();
            calcSeries(a, b, n);
            //in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        }
        in.close();
    }

    private static void calcSeries(int a, int b, int n) {
        int acc=a;

        for (int i = 0; i < n; i++) {
            acc += (Math.pow(2,i)*b);
            System.out.print(acc + " ");

        }
        //System.out.println();
    }
}