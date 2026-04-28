package com.ankitjava.springbatch.interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//Given two strings s1 and s2 in lowercase, check if they are anagrams of each other or not. Two strings are called anagrams of each other if one of them can be converted into another by rearranging its letters.
//
//Two strings are considered anagrams if they contain the same characters with exactly the same frequencies, regardless of their order.
//
//a gentleman = elegant man

//maximumSalr
public class EY {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 1, 2, 5);
        List<Integer> collect = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(i -> i.getValue() == 2).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(collect);
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Ankit", "IT", 50000));
        employees.add(new Employee(2, "Rahul", "HR", 40000));
        employees.add(new Employee(3, "Priya", "Finance", 60000));
        employees.add(new Employee(4, "Amit", "IT", 70000));
        employees.add(new Employee(5, "Neha", "HR", 45000));
        employees.add(new Employee(6, "Suresh", "Finance", 80000));


        Employee employee = employees.stream().max(Comparator.comparingDouble(Employee::getSalary)).get();
        System.out.println(employee.getSalary());
    }

}
