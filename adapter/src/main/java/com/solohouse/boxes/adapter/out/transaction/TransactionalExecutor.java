package com.solohouse.boxes.adapter.out.transaction;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class TransactionalExecutor {
    
    @Transactional
    public <T> T execute(final Supplier<T> supplier) {
        return supplier.get();
    }
}
