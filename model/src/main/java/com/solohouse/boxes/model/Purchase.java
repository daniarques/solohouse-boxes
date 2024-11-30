package com.solohouse.boxes.model;


import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder(toBuilder = true)
public class Purchase {

    Integer id;

    Integer shirtDesignId;

    Integer boxId;

    Integer userId;

    Boolean picked;

    LocalDateTime createdAt;

    LocalDateTime pickedAt;

}
