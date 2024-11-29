package com.solohouse.boxes.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ShirtLine {

    ShirtDesign shirtDesign;

    int amount;

    double price;
}
