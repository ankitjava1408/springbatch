package com.ankitjava.springbatch.config;

import com.ankitjava.springbatch.entity.Customer;
import org.jspecify.annotations.Nullable;
import org.springframework.batch.infrastructure.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Customer,Customer> {
    @Override
    public @Nullable Customer process(Customer customer) throws Exception {
        return customer;
    }
}
