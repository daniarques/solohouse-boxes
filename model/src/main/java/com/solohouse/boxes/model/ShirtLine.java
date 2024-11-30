package com.solohouse.boxes.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ShirtLine {

    ShirtDesign shirtDesign;

    int amount;

    double price;
}
