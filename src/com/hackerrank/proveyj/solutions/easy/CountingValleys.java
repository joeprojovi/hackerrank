package com.hackerrank.proveyj.solutions.easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int valleys = 0;
        int elevation = 0;

        for(char c: s.toCharArray()){
            int step = decode(c);
            if(elevation==0 && step ==-1){
                valleys++;
            }
            elevation += decode(c);
        }

        return valleys;

    }

    private static int decode(char c) {
        int step;
        switch(c) {
            case 'D':
                step = -1;
                break;
            case 'U':
                step = 1;
                break;
            default:
                step = 0;
        }
        return step;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
