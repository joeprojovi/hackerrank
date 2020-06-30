package com.hackerrank.proveyj.solutions.easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ACMICPCTeam {

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {

        List<BigInteger> intReps = new ArrayList<BigInteger>();
        List<Integer> perms = new ArrayList<Integer>();

        for (int i = 0; i < topic.length; i++) {
            intReps.add(new BigInteger(topic[i],2));
        }

        for (int i = 0; i < intReps.size(); i++) {
            for(int j=i+1; j< intReps.size(); j++){
                perms.add( intReps.get(i).or(intReps.get(j)).bitCount() );
            }
        }

        Collections.sort(perms, Collections.reverseOrder());
        int cnt = 1;

        for (int i=1;i<perms.size();i++) {
            if (perms.get(0).equals(perms.get(i))) {
                cnt++;
            }
            else
                break;

        }

        return new int[]{perms.get(0), cnt};

    }

    //private static final File test = "C:/temp/"
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

