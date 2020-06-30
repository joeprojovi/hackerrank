package com.hackerrank.proveyj.solutions.java.medium;

import java.util.*;
class JavaStack{

    public static void main(String [] argh)
    {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            checkInput(input);
        }


    }

    private static void checkInput(String input) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        try {
            for (char c:input.toCharArray()) {

                switch (c) {
                    case '(':
                    case '[':
                    case '{':
                        stack.push(c);
                        break;
                    case ')':
                    case ']':
                    case '}':
                        stack.pop();
                        break;
                }
            }

            if(stack.isEmpty())
                System.out.println("true");
            else
                System.out.println("false");

        } catch (Exception e) {
            System.out.println("false");
        }
    }


}
