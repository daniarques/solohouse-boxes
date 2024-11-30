package com.solohouse.boxes.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BoxLocation {

    double latitude;

    double longitude;
}
