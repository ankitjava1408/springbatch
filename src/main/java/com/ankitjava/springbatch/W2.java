package com.ankitjava.springbatch;

import java.util.*;
import java.util.stream.Collectors;

public class W2 {

    public static void main(String[] args) {
        Product p1 = new Product("mobile","Electronics",40000.00);
        Product p2 = new Product("shirt","Clothing",400.00);
        Product p3 = new Product("Surf","Grocery",40.00);
        Product p4 = new Product("Pizza","Food",400.00);
        Product p5 = new Product(null,"Furniture",0.00);

        List<Product> productList = List.of(p1,p2,p3,p4,p5);
        //list all products by category

        Map<String, List<Product>> collect = productList.stream().collect(Collectors.groupingBy(Product::getCategory));
        //System.out.println(collect);
        Map<String, Long> stringLongMap = productList.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
        System.out.println(stringLongMap);
        List<String> allCategories = List.of(
                "Electronics","Clothing","Grocery","Food","Furniture"
        );
        Map<String, Long> finalMap = new LinkedHashMap<>();
        Map<String, Long> countMap = productList.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.counting()
                ));
        for(String category : allCategories){
            finalMap.put(category, countMap.getOrDefault(category, 0L));
        }



        Map<String, Long> finalMap2 = allCategories.stream()
                .collect(Collectors.toMap(
                        c -> c,
                        c -> countMap.getOrDefault(c, 0L)
                ));
        System.out.println(finalMap2);
       // Optional<String> stringw = Optional.empty();
       // stringw.get();

             //   Optional.of("Ankit");



    }
}
