package com.solohouse.boxes.model;


import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class Box {

    int id;

    String name;

    BoxLocation location;

    List<ShirtLine> shirts;
}
