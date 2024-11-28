package com.solohouse.boxes.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ShirtDesign {

    int id;

    String teamName;

    String style;
}
