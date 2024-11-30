package com.solohouse.boxes.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ShirtDesign {

    int id;

    String teamName;

    String style;

    String imageUrl;
}
