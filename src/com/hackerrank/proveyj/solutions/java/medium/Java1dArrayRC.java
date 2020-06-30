package com.hackerrank.proveyj.solutions.java.medium;
import java.util.*;

public class Java1dArrayRC {

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
        }
        //backward
        i=j-1;
        while (game[i] !=1){
            if(game[i+leap]==0 && !visited.contains(i)){
                visited.add(i);
                if(canWinR(leap, game, i+leap)==true)
                    return true;
            }
            i--;
        }

        return false;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}

