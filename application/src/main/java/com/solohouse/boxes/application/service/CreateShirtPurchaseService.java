package com.solohouse.boxes.application.service;

import com.solohouse.boxes.application.port.in.CreateShirtPurchaseUseCase;
import com.solohouse.boxes.application.port.in.InvalidParameterException;
import com.solohouse.boxes.application.port.out.persistence.BoxRepository;
import com.solohouse.boxes.application.port.out.persistence.EntityNotFoundException;
import com.solohouse.boxes.application.port.out.persistence.InvalidDataException;
import com.solohouse.boxes.application.port.out.persistence.PurchaseRepository;
import com.solohouse.boxes.application.port.out.transaction.TransactionalService;
import com.solohouse.boxes.model.Purchase;
import lombok.RequiredArgsConstructor;

import static java.lang.String.format;

@RequiredArgsConstructor
public class CreateShirtPurchaseService implements CreateShirtPurchaseUseCase {

    private final BoxRepository boxRepository;
    private final PurchaseRepository purchaseRepository;
    private final TransactionalService transactionalService;

    @Override
    public int createPurchase(final Purchase purchase) {
        return this.transactionalService.executeSafely(
                () -> this.decreaseShirtAmountAndCreatePurchase(purchase),
                new InvalidDataException(this.buildErrorMessage(purchase.getBoxId(), purchase.getShirtDesignId())));
    }

    private int decreaseShirtAmountAndCreatePurchase(final Purchase purchase) {

        this.decreaseShirtDesignAmountFromBox(purchase.getBoxId(), purchase.getShirtDesignId());
        return this.purchaseRepository.save(purchase).getId();
    }

    private void decreaseShirtDesignAmountFromBox(final Integer boxId, final Integer shirtDesignId) {

        try {
            this.boxRepository.decreaseShirtDesignAmountFromBox(boxId, shirtDesignId);
        } catch (final EntityNotFoundException e) {
            throw new InvalidParameterException(this.buildErrorMessage(boxId, shirtDesignId));
        }
    }

    private String buildErrorMessage(final Integer boxId, final Integer shirtDesignId) {

        return format("ShirtDesign %s not available for Box %s", shirtDesignId, boxId);
    }
}
