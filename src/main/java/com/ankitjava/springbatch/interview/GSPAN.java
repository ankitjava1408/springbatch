package com.ankitjava.springbatch.interview;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;

public class GSPAN {
    public static void main(String[] args) throws InterruptedException {
        String s = "Ankit kumar chourasia is a Java Developer";
        String collect = Arrays.stream(s.split(" ")).map(rs -> new StringBuilder(rs).reverse()).collect(Collectors.joining(" "));
        System.out.println(collect);
        Optional<String> max = Arrays.stream(s.split(" ")).max(Comparator.comparingInt(String::length));
        System.out.println(max.get().length());
      //

    }
}
