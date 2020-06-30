package com.hackerrank.proveyj.solutions.easy;

import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class BetweenTwoSets {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int numResults = 0;
        //get max of a and min of b bc these are bounds on multiples/factors
        OptionalInt max_a = a
                .stream()
                .mapToInt(v -> v)
                .max();

        OptionalInt min_b = b
                .stream()
                .mapToInt(v -> v)
                .min();

        Predicate<Integer> multipleOfAll = new Predicate<Integer>()
        {
            @Override
            public boolean test(Integer n) {
                for(int i:a){
                    if(n%i!=0)
                        return false;
                }
                return true;
            }
        };

        Predicate<Integer> factorOfAll = new Predicate<Integer>()
        {
            @Override
            public boolean test(Integer n) {
                for(int i:b){
                    if(i%n!=0)
                        return false;
                }
                return true;
            }
        };

        //for every int in max_a to min_b check if both multiple of all a's and factor of all b's
        numResults = (int) Stream.iterate(max_a.getAsInt(), n->n+1)
                .limit(min_b.getAsInt())
                .filter(multipleOfAll)
                .filter(factorOfAll)
                .count();



        return numResults;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = BetweenTwoSets.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
