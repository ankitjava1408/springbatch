package com.ankitjava.springbatch.interview;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;
import jakarta.servlet.Filter;

public class HitachiL2 {


    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;

        List<String> result = Arrays.stream(words)
                // Step 1: frequency map
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                // Step 2: stream entries
                .entrySet()
                .stream()
                // Step 3: custom sorting
                .sorted((e1, e2) -> {
                    if (!e1.getValue().equals(e2.getValue())) {
                        return e2.getValue().compareTo(e1.getValue()); // higher freq first
                    }
                    return e1.getKey().compareTo(e2.getKey()); // lexicographical
                })
                // Step 4: take top k
                .limit(k)
                // Step 5: extract words
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(result);


        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            System.out.println("Task running by: " + Thread.currentThread().getName());
            // DB update, email send, logging, etc.
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task running by: " + Thread.currentThread().getName());
            return "Hello Ankit";
        });
    }

}


