package com.ankitjava.springbatch.interview;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EYAmex {
    public static void sortArray(int[] arr) {
        int low = 0, mid = 0;
        int high = arr.length - 1;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    // swap low and mid
                    int temp0 = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp0;

                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;

                case 2:
                    // swap mid and high
                    int temp2 = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp2;

                    high--;
                    break;
            }

        }

    }
    public static void main(String[] args) {

        int[] array = {1,2,0,0,0,0,2,0,1,1,2};
        sortArray(array);
        for (int num : array) {
            System.out.print(num + " ");
        }

        String s1 ="Java";
        String s2 = "Java";
        String s3 = new String("Java");
        System.out.println(s1 == s2);   // FALSE
        System.out.println(s1 == s3);   //FALSE
        System.out.println(s1.equals(s3)); //TRUE
    }
}
