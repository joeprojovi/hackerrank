package org.provey;

import java.util.ArrayList;
import java.util.List;

public class JoeUtils {
    public static List<Integer> arrayToList(int[] arr){
        List<Integer> list = new ArrayList<>();
        for(int i:arr){
            list.add(i);
        }
        return list;
    }

    public static int[] listToArray(List<Integer> list){
        int[] arr = new int[list.size()];
        int i = 0;

        for(int k:list){
            arr[i++] = k;
        }
        return arr;
    }
}
