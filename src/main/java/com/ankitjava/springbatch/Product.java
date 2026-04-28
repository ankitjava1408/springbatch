package com.ankitjava.springbatch;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String productName;
    private String category;
    private double price;
}
