package com.hackerrank.proveyj.solutions.easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class JumpingOnClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int cur =0;
        int jumps = 0;
        int nxt = 1;
        int nxtnxt = 2;

        while(nxtnxt<c.length) {
            //try to jump double
            if (c[nxtnxt] == 0) {
                jumps++;
                cur = nxtnxt;
                nxt = cur + 1;
                nxtnxt = nxt + 1;
            }
            //if you can't jump single
            else {
                jumps++;
                cur++;
                nxt++;
                nxtnxt++;
            }
        }

        //three scenarios: cur is end, nxt is end, or nxtnxt is end
        if(nxt==c.length-1 || nxtnxt==c.length-1){
            jumps++;
        }

        return jumps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

