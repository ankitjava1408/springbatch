package com.ankitjava.springbatch.interview;

import java.util.*;
import java.util.stream.Collectors;

public class EY2 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("Shekhar",23);
        map.put("Raj",37);
        map.put("Manoj",21);

        Map<String, Integer> sortedMap = map.entrySet()
                .stream()
                .sorted(Comparator.comparing(e->e.getKey().length(),Comparator.reverseOrder())) // ascending
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new   // maintain order
                ));

        System.out.println(sortedMap);

    }
}
