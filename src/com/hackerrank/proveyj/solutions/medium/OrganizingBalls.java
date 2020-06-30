package com.hackerrank.proveyj.solutions.medium;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class OrganizingBalls {

    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {
        long[] countByContainer = new long[container.length];
        long[] countByType = new long[container.length];

        for (int i = 0; i < container.length; i++) {
            for (int j = 0; j < container[i].length; j++) {
                countByType[j]= countByType[j]+ container[i][j];
                countByContainer[i]= countByContainer[i]+ container[i][j];
            }
        }
        Arrays.sort(countByContainer);
        Arrays.sort(countByType);

        for (int i = 0; i < container.length; i++) {
            if (countByContainer[i] != countByType[i])
                return "Impossible";
        }

        return "Possible";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

