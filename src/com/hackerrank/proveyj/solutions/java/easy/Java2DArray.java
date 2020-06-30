package com.hackerrank.proveyj.solutions.java.easy;

import java.util.*;

public class Java2DArray {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().trim().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }

        }

        scanner.close();

        System.out.println(calcLargestHourGlass(arr));
    }

    private static int calcLargestHourGlass(int[][] arr) {
        int hgCnt = calcHourGlass(0,0,arr);

        //foreach row up to the 4th (0,1,2,3)
        for (int i = 0; i < arr.length-2; i++) {
            //foreach corner up to the 4th (0,1,2,3)
            for(int j=0; j<arr.length-2; j++){
                int sum = calcHourGlass(i,j,arr);
                hgCnt = hgCnt >= sum ? hgCnt : sum;
            }
            int[] ints = arr[i];

        }

        return hgCnt;
    }

    private static int calcHourGlass(int i, int j, int[][] arr) {
        return arr[i][j] + arr[i][j+1] + arr[i][j+2] +
                arr[i+1][j+1] +
                arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
    }
}
