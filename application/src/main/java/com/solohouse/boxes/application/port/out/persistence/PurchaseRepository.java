package com.solohouse.boxes.application.port.out.persistence;

import com.solohouse.boxes.model.Purchase;

import java.util.Optional;

public interface PurchaseRepository {

    Optional<Purchase> getById(Integer purchaseId);

    Purchase save(Purchase purchase);

}
