package com.ankitjava.springbatch.interview;

import java.util.Arrays;

public class Mphasis {

    public static double findMiddle(int []a1, int[] a2){

        int[] merged = new int[a1.length+a2.length];
        System.arraycopy(a1,0,merged,0,a1.length);
        System.arraycopy(a2,0,merged,a1.length, a2.length);
         Arrays.sort(merged);
        int n= merged.length;
        if(n%2==0){
            return (merged[n/2-1]+merged[n/2])/2.0;
        }
        else{
            return merged[n/2];
        }


    }
    public static void main(String[] args) {
     int[] a1 = {1,3};
     int[] a2 = {2};
     System.out.println(findMiddle(a1,a2));

    }
}
