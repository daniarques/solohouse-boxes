package com.solohouse.boxes.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ShirtPurchase {

    Box box;

    User user;

    ShirtDesign shirtDesign;

    boolean picked;
}
