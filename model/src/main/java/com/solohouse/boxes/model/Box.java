package com.solohouse.boxes.model;


import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Box {

    int id;

    String name;

    BoxLocation location;

    List<ShirtLine> shirts;
}
