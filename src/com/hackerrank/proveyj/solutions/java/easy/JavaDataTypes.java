package com.hackerrank.proveyj.solutions.java.easy;

import java.util.*;
import java.io.*;



class JavaDataTypes{
    public static void main(String [] argh)
    {

        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        for(int i=0;i<t;i++)
        {

            try
            {
                long x=sc.nextLong();
                System.out.println(x+" can be fitted in:");
                //byte 8 2^7=128, short 16 2^15=32_768, int 32 2^31=2_147_483_648, long 64 2^63
                if(x>=-128 && x<=127) System.out.println("* byte");
                if(x>=-32_768 && x<=32_767) System.out.println("* short");
                if(x>=-2_147_483_648 && x<=2_147_483_647) System.out.println("* int");
                if(x>=Long.MIN_VALUE && x<=Long.MAX_VALUE) System.out.println("* long");
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }

        }
    }
}




