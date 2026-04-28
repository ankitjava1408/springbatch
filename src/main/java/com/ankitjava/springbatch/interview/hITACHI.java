package com.ankitjava.springbatch.interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class hITACHI {
    public static void main(String[] args) {
        String s = "Java articles are Awesome";
        String s1 = Arrays.stream(s.toLowerCase().split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst().get();

        System.out.println(s1);
    }
}
