package com.solohouse.boxes.adapter.in.rest.model;

import org.springframework.lang.NonNull;

public record PurchaseWebModel(@NonNull Integer boxId, @NonNull Integer shirtId, @NonNull Integer userId) {
}
