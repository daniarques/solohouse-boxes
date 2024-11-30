package com.solohouse.boxes.application.service;

import com.solohouse.boxes.application.port.in.InvalidParameterException;
import com.solohouse.boxes.application.port.in.NotFoundException;
import com.solohouse.boxes.application.port.in.PickShirtPurchaseUseCase;
import com.solohouse.boxes.application.port.out.persistence.PurchaseRepository;
import com.solohouse.boxes.model.Purchase;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

import static java.lang.String.format;

@RequiredArgsConstructor
public class PickShirtShirtPurchaseService implements PickShirtPurchaseUseCase {

    private final PurchaseRepository purchaseRepository;

    @Override
    public void pickPurchase(final Integer purchaseId, final Integer userId) {

        final Purchase purchase = this.purchaseRepository.getById(purchaseId)
                .orElseThrow(() -> this.buildNotFoundException(purchaseId));

        if (!purchase.getUserId().equals(userId)) {
            throw this.buildNotFoundException(purchaseId);
        }
        if (purchase.getPicked()) {
            throw new InvalidParameterException("Purchase already picked");
        }

        this.purchaseRepository.save(this.buildPurchaseWithPickedFlag(purchase));
    }

    private Purchase buildPurchaseWithPickedFlag(final Purchase purchase) {

        return purchase.toBuilder()
                .picked(true)
                .pickedAt(LocalDateTime.now())
                .build();
    }

    private NotFoundException buildNotFoundException(final Integer purchaseId) {

        return new NotFoundException(format("Purchase with id %s not found", purchaseId));
    }


}
