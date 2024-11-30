package com.solohouse.boxes.adapter.out.persistence.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class BoxStockPKJpaEntity implements Serializable {

    @Column(name = "shirt_design_id")
    private int shirtDesignId;

    @Column(name = "box_id")
    private int boxId;
}
