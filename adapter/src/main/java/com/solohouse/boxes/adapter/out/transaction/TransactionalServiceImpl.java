package com.solohouse.boxes.adapter.out.transaction;

import com.solohouse.boxes.application.port.out.persistence.InvalidDataException;
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
    public <T> T executeSafely(final Supplier<T> supplier) {
        try {
            return transactionalExecutor.execute(supplier);
        } catch (final DataIntegrityViolationException e) {
            throw new InvalidDataException("Unable to perform action based on present data");
        }
    }

}