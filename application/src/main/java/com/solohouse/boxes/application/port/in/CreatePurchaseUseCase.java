package com.solohouse.boxes.application.port.in;

public interface CreatePurchaseUseCase {

    void createPurchase(Integer boxId, Integer shirtDesignId, Integer userId);

}
