package com.hackerrank.proveyj.solutions.java.easy;

import java.io.*;
import java.util.*;

public class JavaNegativeSubArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrlen = sc.nextInt();
        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] strArr = sc.nextLine().trim().split(" ");

        int[] arr = new int[arrlen];

        for (int i = 0; i < arrlen; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        sc.close();

        int sum = 0;
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) { //foreach start
            for(int j = i; j< arr.length; j++){ //foreach end pt
                sum = 0;
                for(int k = i; k <= j; k++ ){
                    sum += arr[k];
                }
                if(sum<0)
                    cnt++;
            }
        }

    System.out.println(cnt);
    }
}
