package com.ankitjava.springbatch.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

//Write the program for "Count the occurrences of each element" using stream:
//
//Integer[] ints = {1, 2, 3, 1, 1, 3};
public class Wipro {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cat", "dog");
        Map<Integer, List<String>> collect = words.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(collect);
    }


}
