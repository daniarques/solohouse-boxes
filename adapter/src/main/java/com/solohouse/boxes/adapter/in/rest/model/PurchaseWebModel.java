package com.solohouse.boxes.adapter.in.rest.model;

import java.time.LocalDateTime;

public record PurchaseWebModel(Integer id, Integer boxId, Integer shirtId, Integer userId, Boolean picked,
                               LocalDateTime createdAt, LocalDateTime pickedAt) {
}
