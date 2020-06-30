package com.hackerrank.proveyj.solutions.easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long t = n/s.length();
        long r = n%s.length();
        long cnt = 0;
        int cnt_r = 0;
        char[] sArr = s.toCharArray();

        for(char c :sArr){
            if(c=='a') {
                cnt++;
            }
        }

        for (int i = 0; i < r; i++) {
             if(sArr[i]=='a'){
                 cnt_r++;
             }

        }


        return cnt*t + cnt_r;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

