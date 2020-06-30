package com.hackerrank.proveyj.solutions.easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MiniMaxSum {


    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        long maxSum = Long.MIN_VALUE;
        long minSum = Long.MAX_VALUE;

        long sum = 0;

        for(int i =0;i<arr.length; i++){
            for(int j=0;j<arr.length;j++){
                if(j!=i)
                    sum+=arr[j];
            }
            if(maxSum< sum)
                maxSum = sum;
            if(minSum>sum)
                minSum =sum;
            sum=0;
        }
        System.out.println(Long.toString(minSum) + " " + Long.toString(maxSum));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
