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

public class DayOfTheProgrammer {

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        final String LEAP_YEAR = "12.09.";
        final String YEAR = "13.09.";

        if(year<1918){
            //georgian: leap years mod 4
            if(year%4==0)
                return LEAP_YEAR+year;
            else
                return YEAR+year;
        }
        else if(year==1918){
            return "26.09.1918";
        }
        else{
            if(year%400==0 || (year%4==0 && year%100!=0))
                return LEAP_YEAR+year;
            else
                return YEAR+year;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
