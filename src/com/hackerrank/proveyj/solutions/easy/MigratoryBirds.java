package com.hackerrank.proveyj.solutions.easy;

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

public class MigratoryBirds {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Integer> birdSightings = new HashMap(arr.size());

        int maxId = arr.get(0);
        int maxValue = 0;

        for(Integer i: arr){
            if(birdSightings.containsKey(i)){
                birdSightings.put(i,birdSightings.get(i)+1);
                if(birdSightings.get(i)>maxValue || (birdSightings.get(i).intValue()==maxValue && i.intValue()<=maxId )) {
                    maxValue = birdSightings.get(i);
                    maxId = i;
                }
            }
            else{
                birdSightings.put(i, 1);
            }
        }

        return maxId;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}

