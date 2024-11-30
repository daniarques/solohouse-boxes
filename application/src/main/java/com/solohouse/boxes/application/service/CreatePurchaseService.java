package com.solohouse.boxes.application.service;

import com.solohouse.boxes.application.port.in.CreatePurchaseUseCase;
import com.solohouse.boxes.application.port.in.InvalidParameterException;
import com.solohouse.boxes.application.port.out.persistence.BoxRepository;
import com.solohouse.boxes.application.port.out.persistence.EntityNotFoundException;
import com.solohouse.boxes.application.port.out.persistence.PurchaseRepository;
import com.solohouse.boxes.application.port.out.transaction.TransactionalService;
import com.solohouse.boxes.model.Purchase;
import lombok.RequiredArgsConstructor;

import static java.lang.String.format;

@RequiredArgsConstructor
public class CreatePurchaseService implements CreatePurchaseUseCase {

    private final BoxRepository boxRepository;
    private final PurchaseRepository purchaseRepository;
    private final TransactionalService transactionalService;

    @Override
    public void createPurchase(final Integer boxId, final Integer shirtDesignId, final Integer userId) {
        transactionalService.executeSafely(() -> {
            this.decreaseShirtAmountAndCreatePurchase(boxId, shirtDesignId, userId);
            return null;
        });
    }

    private void decreaseShirtAmountAndCreatePurchase(final Integer boxId, final Integer shirtDesignId, final Integer userId) {

        this.decreaseShirtDesignAmountFromBox(boxId, shirtDesignId);
        this.purchaseRepository.create(this.buildPurchase(boxId, shirtDesignId, userId));
    }

    private void decreaseShirtDesignAmountFromBox(final Integer boxId, final Integer shirtDesignId) {

        try {
            this.boxRepository.decreaseShirtDesignAmountFromBox(boxId, shirtDesignId);
        } catch (final EntityNotFoundException e) {
            throw new InvalidParameterException(format("ShirtDesign %s not available for Box %s", shirtDesignId, boxId));
        }
    }

    private Purchase buildPurchase(final Integer boxId, final Integer shirtDesignId, final Integer userId) {

        return Purchase.builder()
                .boxId(boxId)
                .shirtDesignId(shirtDesignId)
                .userId(userId)
                .build();
    }
}
