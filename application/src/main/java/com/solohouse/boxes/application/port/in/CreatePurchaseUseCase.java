package com.solohouse.boxes.application.port.in;

import com.solohouse.boxes.model.Purchase;

public interface CreatePurchaseUseCase {

    int createPurchase(Purchase purchase);

}
