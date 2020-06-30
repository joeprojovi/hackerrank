package com.hackerrank.proveyj.solutions.easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class EqualityInArray {

    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
        //int moves = 0;
        int[] cnts = new int[101];
        //int maxIdx = 0;
        int maxCnt = 0;

        //find the max occurring
        for (int i = 0; i < arr.length; i++) {
            cnts[arr[i]]++;
            if(maxCnt < cnts[arr[i]]) {
                maxCnt = cnts[arr[i]];
                //maxIdx = i;
            }
        }

        return arr.length-maxCnt;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = equalizeArray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

