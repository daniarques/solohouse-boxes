package com.solohouse.boxes.application.port.in;

import com.solohouse.boxes.model.Page;
import com.solohouse.boxes.model.Purchase;

public interface SearchShirtPurchasesUseCase {

    Page<Purchase> searchPurchases(final Integer userId, final Boolean picked, final Integer size, final Integer page);

}
