package com.hackerrank.proveyj.solutions.medium;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Encryption {

    // Complete the encryption function below.
    static String encryption(String s) {
        String ns = s.replace(" ", "");
        int k = 0;
        double len = Math.sqrt(ns.length());
        int rows = Double.valueOf(Math.floor(len)).intValue();
        int cols = Double.valueOf(Math.ceil(len)).intValue();
        if(rows*cols < ns.length())
            rows++;

        char[][] ar = new char[rows][cols];

        for (int i = 0; i < rows; i++) { //rows
            for(int j = 0; j< cols; j++) { //cols
                if(k<ns.length()) {
                    ar[i][j] = ns.charAt(k++);
                }
                else
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();

        k=0;
        for (int i = 0; i < cols; i++) {
            for(int j=0; j< rows; j++){
                if(ar[j][i]!=0) {
                    sb.append(ar[j][i]);
                }
            }
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

