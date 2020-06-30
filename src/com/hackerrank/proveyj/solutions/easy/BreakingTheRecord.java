package com.hackerrank.proveyj.solutions.easy;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class BreakingTheRecord {



    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {
        int min = scores[0];
        int max = scores[0];
        int minCnt = 0;
        int maxCnt = 0;
        int[] cnts = new int[2];

        for (int i=0;i<scores.length;i++){
            if(scores[i]>max){
                max = scores[i];
                maxCnt++;
            }
            else if(scores[i]<min){
                min = scores[i];
                minCnt++;
            }
        }
        cnts[0] = maxCnt;
        cnts[1] = minCnt;
        return cnts;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}