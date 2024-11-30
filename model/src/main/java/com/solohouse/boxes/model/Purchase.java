package com.solohouse.boxes.model;


import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Purchase {

    Integer id;

    Integer shirtDesignId;

    Integer boxId;

    Integer userId;

}
