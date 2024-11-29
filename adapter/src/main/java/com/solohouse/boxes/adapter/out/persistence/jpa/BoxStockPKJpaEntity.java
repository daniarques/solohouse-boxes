package com.solohouse.boxes.adapter.out.persistence.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class BoxStockPKJpaEntity implements Serializable {

    @Column(name = "shirt_design_id")
    private Integer shirtDesignId;

    @Column(name = "box_d")
    private Integer boxId;
}
