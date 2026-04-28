package com.ankitjava.springbatch.interview;

import java.util.*;
import java.util.stream.Collectors;

public class Hcl {
    public static void main(String[] args) {
        String[] str = {"bbbb", "Java", "book"};
        List<String> collect = Arrays.stream(str).map(
                s -> {
                    Map<Character, Long> freqMap = s.chars()
                            .mapToObj(c -> (char) c)
                            .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));
                    return freqMap.entrySet().stream()
                            .filter(e -> e.getValue() == 1)
                            .map(e -> String.valueOf(e.getKey()))
                            .collect(Collectors.joining());
                }).filter(s -> !s.isEmpty()).collect(Collectors.toList());

        System.out.println(String.join(", ", collect));
    }
}

