package com.solohouse.boxes.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoxLocation {

    double latitude;

    double longitude;
}
