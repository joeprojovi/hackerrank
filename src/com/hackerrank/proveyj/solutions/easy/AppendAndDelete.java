package com.hackerrank.proveyj.solutions.easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AppendAndDelete {

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        //case 1: all the way and back, ie k>=s+t
        //case 2: can't get all the way and back, can you use commonalities
        //      if yes, your extras needs to mod%2
        //      if no, then no
        int total = s.length()+t.length();

        if(k>=total){
            return "Yes";
        }
        else{
            int overlapping = s.length()<=t.length()?s.length():t.length();
            int shared = calcFrontShared(s.toCharArray(),t.toCharArray(),overlapping);
            int moves = total-shared*2;
            if(moves<=k){
                if((k-moves)%2==0)
                    return "Yes";
                else
                    return "No";
            }else
                return "No";
        }

        /*
        int extra = Math.abs(s.length()-t.length());


        //(overlapping-shared) * 2 + extra
        if(k>=((overlapping-shared) * 2 + extra)) {
            //if you don't go all the way to the beginning you need to have even number of extra moves
            if(hitStart(s,t,k))
                return "Yes";
            else
                return x%2;
        }
        else{
            return "No";
        }
*/
    }

    private static boolean hitStart(String s, String t, int k) {
        if(k>=s.length()+t.length()){
            return true;
        }else
            return false;
    }

    private static int calcFrontShared(char[] s, char[] t, int n) {
        int cnt = 0;
        while(cnt<n){
            if(s[cnt]==t[cnt])
                cnt++;
            else{
                break;
            }
        }
        return cnt;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

