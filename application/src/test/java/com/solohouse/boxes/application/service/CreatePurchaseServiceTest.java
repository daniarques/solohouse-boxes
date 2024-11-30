package com.solohouse.boxes.application.service;

import com.solohouse.boxes.application.port.in.InvalidParameterException;
import com.solohouse.boxes.application.port.out.persistence.BoxRepository;
import com.solohouse.boxes.application.port.out.persistence.EntityNotFoundException;
import com.solohouse.boxes.application.port.out.persistence.PurchaseRepository;
import com.solohouse.boxes.model.Purchase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;

@ExtendWith(MockitoExtension.class)
class CreatePurchaseServiceTest {

    public static final int BOX_ID = 1;
    public static final int SHIRT_DESIGN_ID = 2;
    public static final int USER_ID = 3;

    @Mock
    private BoxRepository boxRepository;

    @Mock
    private PurchaseRepository purchaseRepository;

    @InjectMocks
    private CreatePurchaseService createPurchaseService;

    @Test
    void when_createPurchase_should_create() throws EntityNotFoundException {
        given(this.boxRepository.isShirtDesignAvailableInBox(BOX_ID, SHIRT_DESIGN_ID)).willReturn(true);

        createPurchaseService.createPurchase(BOX_ID, SHIRT_DESIGN_ID, USER_ID);

        final Purchase expectedPurchase = Purchase.builder()
                .boxId(BOX_ID)
                .shirtDesignId(SHIRT_DESIGN_ID)
                .userId(USER_ID)
                .build();

        then(this.purchaseRepository).should().create(expectedPurchase);
    }

    @Test
    void when_createPurchase_notAvailable_should_failInvalidParameter() throws EntityNotFoundException {
        given(this.boxRepository.isShirtDesignAvailableInBox(BOX_ID, SHIRT_DESIGN_ID)).willReturn(false);

        assertThatThrownBy(() -> createPurchaseService.createPurchase(BOX_ID, SHIRT_DESIGN_ID, USER_ID))
                .isInstanceOf(InvalidParameterException.class)
                .hasMessage("ShirtDesign 2 not available for Box 1");

        then(this.purchaseRepository).should(never()).create(any());
    }

    @Test
    void when_createPurchase_notFound_should_failInvalidParameter() throws EntityNotFoundException {
        given(this.boxRepository.isShirtDesignAvailableInBox(BOX_ID, SHIRT_DESIGN_ID)).willThrow(EntityNotFoundException.class);

        assertThatThrownBy(() -> createPurchaseService.createPurchase(BOX_ID, SHIRT_DESIGN_ID, USER_ID))
                .isInstanceOf(InvalidParameterException.class)
                .hasMessage("ShirtDesign 2 not available for Box 1");

        then(this.purchaseRepository).should(never()).create(any());
    }

}