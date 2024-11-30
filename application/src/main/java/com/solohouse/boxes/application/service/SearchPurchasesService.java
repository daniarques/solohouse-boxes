package com.solohouse.boxes.application.service;

import com.solohouse.boxes.application.port.in.SearchPurchasesUseCase;
import com.solohouse.boxes.application.port.out.persistence.PurchaseRepository;
import com.solohouse.boxes.model.Page;
import com.solohouse.boxes.model.Purchase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SearchPurchasesService implements SearchPurchasesUseCase {

    private final PurchaseRepository purchaseRepository;
    
    @Override
    public Page<Purchase> searchPurchases(final Integer userId, final Boolean picked, final Integer size, final Integer page) {

        return this.purchaseRepository.findAllByFilters(userId, picked, size, page);
    }
}
