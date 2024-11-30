package com.solohouse.boxes.adapter.out.transaction;

import com.solohouse.boxes.application.port.out.transaction.TransactionalService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class TransactionalServiceImpl implements TransactionalService {

    private final TransactionalExecutor transactionalExecutor;

    @Override
    public <T> T executeSafely(final Supplier<T> supplier, final RuntimeException exceptionOnFail) {
        try {
            return transactionalExecutor.execute(supplier);
        } catch (final DataIntegrityViolationException e) {
            throw exceptionOnFail;
        }
    }

}