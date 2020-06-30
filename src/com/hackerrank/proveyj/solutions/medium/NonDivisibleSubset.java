package com.hackerrank.proveyj.solutions.medium;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */
    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int[] arr = new int[k];
        int cnt = 0;

        //bucket em
        for (int i = 0; i < s.size(); i++) {
            Integer integer =  s.get(i);
            arr[integer%k]++;
        }

        //take one zero and then toss low buckets
        if(arr[0]>0){
            cnt++;
        }


        for (int i = 1; i <= k/2; i++) {

            if(i==k-i && arr[i]>0){
                cnt++;
                break;
            }

            int i1 = arr[i];
            int i2 = arr[k-i];

            if(i1>=i2)
                cnt+=i1;
            else
                cnt+=i2;

        }

        //return cnt of nums in high buckets
        return cnt;
    }

}


public class NonDivisibleSubset {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


