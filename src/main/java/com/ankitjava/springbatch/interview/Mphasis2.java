package com.ankitjava.springbatch.interview;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

record Student(String name, int grade){
//    studying in "Grade 10"
//    ensure you filter only the unquie names
//
//    sort the names and print it


}
public class Mphasis2 {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Krishna", 10),
                new Student("Bob", 12),
                new Student("Alice", 10),
                new Student("Venkat", 10), // Duplicate
                new Student("Ramesh", 10),
                new Student("Durga", 10),
                new Student("Venkat", 10)
        );
        List<String> collect1 = students.stream().filter(student -> student.grade() == 10).map(Student::name).distinct().sorted(Comparator.naturalOrder()).collect(Collectors.toList());

        System.out.println(collect1);
    }


}
