package com.ankitjava.springbatch.interview;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Atos {
    public static void main(String[] args) {
        String s = "abbaca";
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {

            int len = result.length();

            // if last char same → remove it (duplicate)
            if (len > 0 && result.charAt(len - 1) == c) {
                result.deleteCharAt(len - 1);
            } else {
                result.append(c);
            }
        }

        System.out.println(result.toString()); // output: ca
    }

    }


