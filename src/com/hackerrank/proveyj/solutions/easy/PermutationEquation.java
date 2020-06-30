package com.hackerrank.proveyj.solutions.easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PermutationEquation {

    // Complete the permutationEquation function below.
    static int[] permutationEquation(int[] p) {
        int[] r = new int[p.length];
        //for i=1,2,3,4,..n
        for(int i=1; i<=p.length; i++){
            //find index j of value p[j]=1,2,3...
            for(int j=0; j<p.length; j++){
                if(p[j]==i) {
                    //once have index j, find it in p and return that index k
                    for(int k=0; k<p.length; k++){
                        if(p[k]==j+1) {
                            r[i-1] = k+1;
                            break;
                        }
                    }
                    break;
                }
            }
        }

        return r;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        int[] result = permutationEquation(p);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

