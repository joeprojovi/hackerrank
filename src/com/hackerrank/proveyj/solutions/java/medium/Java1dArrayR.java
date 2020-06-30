package com.hackerrank.proveyj.solutions.java.medium;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Java1dArrayR {

    public static Set<Integer> visited = new HashSet<Integer>();

    public static boolean canWin(int leap, int[] game) {
        visited.clear();
        int i = 0;
        while (game[i] !=1){
            if(i+leap>=game.length)
                return  true;
            else if(game[i+leap]==0 && !visited.contains(i)){
                visited.add(i);
                if(canWinR(leap, game, i+leap)==true)
                    return true;
            }
            i++;
            if(i>=game.length)
                return true;
        }
        return false;
    }

    public static boolean canWinR(int leap, int[] game, int j){
        //forward
        int i = j;
        while (game[i] !=1){
            if(i+leap>=game.length)
                return  true;
            else if(game[i+leap]==0 && !visited.contains(i)){
                visited.add(i);
                if(canWinR(leap, game, i+leap)==true)
                    return true;
            }
            i++;
            if(i>=game.length)
                return true;
        }
        //backward
        i=j-1;
        while (i>=0 && game[i] !=1){
            if(game[i+leap]==0 && !visited.contains(i)){
                visited.add(i);
                if(canWinR(leap, game, i+leap)==true)
                    return true;
            }
            i--;
        }

        return false;
    }


    public static void main(String[] args) throws FileNotFoundException {
        //Scanner scan = new Scanner(System.in);
        File test = new File("C:/tmp/test_2.txt");
        Scanner scan = new Scanner(test);

        File ansFile = new File("C:/tmp/ans_2.txt");
        Scanner scanAns = new Scanner(ansFile);

        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }
            String myAns = canWin(leap, game) ? "YES" : "NO" ;
            String ans = scanAns.next();
            if(!myAns.equals(ans)) {
                System.out.println((5000 - q) + ": " + myAns + "/ " + ans);
                System.out.println(n + " " + leap);
                for (int i = 0; i < game.length; i++) {
                    System.out.print(game[i] + " ");
                }
                System.out.println();
            }
        }
        scan.close();
    }
}

