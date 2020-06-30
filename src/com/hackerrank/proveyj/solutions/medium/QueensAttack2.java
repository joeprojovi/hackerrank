package com.hackerrank.proveyj.solutions.medium;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class QueensAttack2 {

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int[] bucketMin = new int[8];
        int sum=0;
        //add the board boundary to the buckets
        for (int i = 0; i < bucketMin.length; i++) {
            bucketMin[i]=getBoundaryValue(r_q, c_q, n, i);
        }

        //bucket the min relevant obstacles into 8 buckets/spots
        for (int i = 0; i < k; i++) { //foreach obstacle
            //check if obstacle is on each ray
            int[] bucketValue = getObstacleValue(r_q, c_q, obstacles[i][0], obstacles[i][1]);
            if(bucketValue[0]!=-1 && bucketMin[bucketValue[0]] > bucketValue[1]){
                bucketMin[bucketValue[0]] = bucketValue[1];
            }
        }
        //calc the distance between min of(starting pt and each of 8 min obstacles AND board boundary)
        for (int i = 0; i < bucketMin.length; i++) {
            sum += bucketMin[i];
        }
        return sum;
    }

    private static int getBoundaryValue(int r_q, int c_q, int n, int i) {
        switch(i){
            case 0: //x-axis
                return n-c_q;
            case 1: //Q1
                return Math.min(n-c_q, n-r_q);

            case 2: //y-axis
                return n-r_q;

            case 3: //Q2
                return Math.min(c_q-1, n-r_q);

            case 4: //neg x-axis
                return c_q-1;

            case 5: //Q3
                return Math.min(c_q-1, r_q-1);

            case 6: //neg y-axis
                return r_q-1;

            case 7: //Q4
                return Math.min(r_q-1, n-c_q);

            default:
                return -1;
        }
    }

    private static int[] getObstacleValue(int y, int x, int yo, int xo) {
        //calc slope = dy/dx
        int dy = yo-y;
        int dx = xo-x;

        //pos x axis
        if(dy==0 && dx>0){
            return new int[]{0,dx-1};
        }
        //fist quadrant
        else if(dy==dx && dx>0){
            return new int[]{1,dx-1};
        }
        //pos y axis
        else if(dy>0 && dx == 0){
            return new int[]{2,dy-1};
        }
        //second quadrant
        else if(dy>0 && -1*dx == dy){
            return new int[]{3,dy-1};
        }
        //neg x axis
        else if(dy==0 && dx < 0){
            return new int[]{4,(-1*dx)-1};
        }
        //third quadrant
        else if(dy<0 && dx==dy){
            return new int[]{5,(-1*dx)-1};
        }
        //neg y axis
        else if(dy<0 && dx ==0){
            return new int[]{6,(-1*dy)-1};
        }
        //4th quadrant
        else if(dy<0 && -1*dx==dy){
            return new int[]{7,dx-1};
        }
        else
            return new int[]{-1,-1};

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

