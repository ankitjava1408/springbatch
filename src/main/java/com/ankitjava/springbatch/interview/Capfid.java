package com.ankitjava.springbatch.interview;

import java.util.List;

public class Capfid {
    public static void main(String[] args) {
        List<String> names = List.of("Ankit", "Mahe");
        List<String> list = names.stream().map(String::toUpperCase).toList();
        System.out.println(list);

        List<Integer> unique = List.of(1,2,2,3,3,4);
        List<Integer> list1 = unique.stream().distinct().toList();
        System.out.println(list1);


    }
}
