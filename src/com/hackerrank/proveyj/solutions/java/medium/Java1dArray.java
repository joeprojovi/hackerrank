package com.hackerrank.proveyj.solutions.java.medium;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Java1dArray {

    public static boolean canWin(int leap, int[] game) {

        int cur = 0;
        List<Integer> visitedNeg = new ArrayList<>();
        List<Integer> visitedPos = new ArrayList<>();
        List<Integer> visitedLeap = new ArrayList<>();
        List<Integer> visitedNegLeap = new ArrayList<>();

        while(cur+leap < game.length) {
            if (game[cur + leap] == 0 && !visitedLeap.contains((Integer) (cur))) {
                visitedLeap.add(cur);
                cur += leap;

            } else if (game[cur + 1] == 0 && !visitedPos.contains((Integer) (cur))){
                visitedPos.add(cur);
                cur++;

            }
            else if((cur-1)>=0 && game[cur-1]==0 && !visitedNeg.contains((Integer)(cur))) {
                visitedNeg.add(cur);
                cur--;
                visitedPos.add(cur);//don't go back forward
            }
            else if ((cur-leap)>=0 && game[cur - leap] == 0 && !visitedNegLeap.contains((Integer)(cur))) {
                visitedNegLeap.add(cur);
                cur -= leap;
                visitedNeg.clear();
                visitedPos.clear();

            }
            else
                return false;
        }

        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        //Scanner scan = new Scanner(System.in);
        File test = new File("C:/tmp/test.txt");
        Scanner scan = new Scanner(test);

        File ansFile = new File("C:/tmp/ans.txt");
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
