package com.solohouse.boxes.application.port.out.transaction;

import java.util.function.Supplier;

public interface TransactionalService {

    <T> T executeSafely(Supplier<T> supplier);

}