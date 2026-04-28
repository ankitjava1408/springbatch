package com.ankitjava.springbatch.interview;
//1,2,3,4
//
//Product except the self
//
//24,12,8,6

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Accolite {
    public static void findPairs(int[] nums, int target){

            Set<Integer> seen = new HashSet<>();

            for (int num : nums) {
                int complement = target - num;

                if (seen.contains(complement)) {
                    System.out.println(complement + " + " + num + " = " + target);
                }

                seen.add(num);
            }
    }
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};// 9
        int target = 9;
        findPairs(arr, target);


    }
    }
