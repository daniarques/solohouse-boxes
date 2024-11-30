package com.solohouse.boxes.application.service;

import com.solohouse.boxes.application.port.in.InvalidParameterException;
import com.solohouse.boxes.application.port.in.NotFoundException;
import com.solohouse.boxes.application.port.out.persistence.PurchaseRepository;
import com.solohouse.boxes.model.Purchase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;

@ExtendWith(MockitoExtension.class)
class PickShirtPurchaseServiceTest {

    public static final int PURCHASE_ID = 123;
    public static final int USER_ID = 111;
    public static final Purchase PURCHASE_NON_PICKED = Purchase.builder()
            .userId(USER_ID)
            .picked(false)
            .build();
    public static final Purchase PURCHASE_PICKED = Purchase.builder()
            .userId(USER_ID)
            .picked(true)
            .build();
    public static final int OTHER_USER_IR = 222;
    @Mock
    private PurchaseRepository purchaseRepository;

    @InjectMocks
    private PickShirtShirtPurchaseService pickShirtPurchaseService;

    @Test
    void when_pickPurchase_should_save() {

        given(this.purchaseRepository.getById(PURCHASE_ID)).willReturn(Optional.of(PURCHASE_NON_PICKED));

        this.pickShirtPurchaseService.pickPurchase(PURCHASE_ID, USER_ID);

        then(this.purchaseRepository).should().save(PURCHASE_PICKED);
    }

    @Test
    void when_pickPurchase_notFound_should_failNotFound() {

        given(this.purchaseRepository.getById(PURCHASE_ID)).willReturn(Optional.empty());

        assertThatThrownBy(() -> this.pickShirtPurchaseService.pickPurchase(PURCHASE_ID, USER_ID))
                .isInstanceOf(NotFoundException.class)
                .hasMessage("Purchase with id 123 not found");

        then(this.purchaseRepository).should(never()).save(any());
    }

    @Test
    void when_pickPurchase_differentUser_should_failNotFound() {

        given(this.purchaseRepository.getById(PURCHASE_ID)).willReturn(Optional.of(Purchase.builder()
                .userId(OTHER_USER_IR)
                .picked(false)
                .build()));

        assertThatThrownBy(() -> this.pickShirtPurchaseService.pickPurchase(PURCHASE_ID, USER_ID))
                .isInstanceOf(NotFoundException.class)
                .hasMessage("Purchase with id 123 not found");

        then(this.purchaseRepository).should(never()).save(any());
    }

    @Test
    void when_pickPurchase_alreadyPicked_should_failInvalidParameter() {

        given(this.purchaseRepository.getById(PURCHASE_ID)).willReturn(Optional.of(PURCHASE_PICKED));

        assertThatThrownBy(() -> this.pickShirtPurchaseService.pickPurchase(PURCHASE_ID, USER_ID))
                .isInstanceOf(InvalidParameterException.class)
                .hasMessage("Purchase already picked");

        then(this.purchaseRepository).should(never()).save(any());
    }
}