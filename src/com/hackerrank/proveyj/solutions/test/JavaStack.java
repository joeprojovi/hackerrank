package com.hackerrank.proveyj.solutions.test;

import java.util.*;
import java.util.Scanner;

// Write your code here. DO NOT use an access modifier in your class declaration.
class Parser {
    void checkColon(){;}

    boolean isBalanced(String s){
        boolean r;
        Stack<Character> stck = new Stack<>();
        int cnt = 0;

        for(char c: s.toCharArray()){
            if(stck.isEmpty()){
                stck.push(c);
            }
            else if(stck.peek() == match(c)){
                stck.pop();
            }
            else{
                stck.push(c);
            }
        }

        return stck.isEmpty();
    }

    private char match(char c) {
        switch (c){
            case '{':
                return 'x';
            case '}':
                return '{';
            case '(':
                return 'y';
            case ')':
                return '(';
            default:
                return 'z';
        }
    }
}

class Solution {

    public static void main(String[] args) {
        Parser parser = new Parser();

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            System.out.println(parser.isBalanced(in.next()));
        }

        in.close();
    }
}
