package com.solohouse.boxes.application.port.out.persistence;

import com.solohouse.boxes.model.Purchase;

public interface PurchaseRepository {

    void create(Purchase purchase);
}
