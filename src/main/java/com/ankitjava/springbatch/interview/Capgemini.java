package com.ankitjava.springbatch.interview;


import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//o/p - a-2,k-2
public class Capgemini {

    public static void main(String[] args) {
        String s = "AnkitKumar";
        Map<String, Long> collect = Arrays.stream(s.toLowerCase().split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println(collect);
        List<String> collect1 = collect.entrySet().stream().filter(e -> e.getValue() == 2).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(collect1);

    }
}
