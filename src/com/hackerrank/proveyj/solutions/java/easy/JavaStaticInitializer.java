package com.hackerrank.proveyj.solutions.java.easy;

import java.util.*;

public class JavaStaticInitializer {

    static boolean flag = true;
    static int B;
    static int H;

    static{

        Scanner sc = new Scanner(System.in);
        B = sc.nextInt();
        sc.nextLine();
        H = sc.nextInt();
        sc.nextLine();
        if(B<0 || H<0){
            flag = false;
        }
    }

    public static void main(String[] args){

        if(flag){
            int area=B*H;
            System.out.print(area);
        }
        else
        {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }

    }//end of main

}//end of class
