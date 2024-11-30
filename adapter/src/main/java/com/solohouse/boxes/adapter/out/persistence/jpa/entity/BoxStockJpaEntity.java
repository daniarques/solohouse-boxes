package com.solohouse.boxes.adapter.out.persistence.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "box_stock")
public class BoxStockJpaEntity {

    @Id
    @Embedded
    BoxStockPKJpaEntity id;

    @Column(name = "available_amount")
    private int availableAmount;

    @Column(name = "real_amount")
    private int realAmount;

    private double price;

    @ManyToOne
    @MapsId("boxId")
    @JoinColumn(name = "box_id")
    private BoxJpaEntity box;

    @ManyToOne
    @MapsId("shirtDesignId")
    @JoinColumn(name = "shirt_design_id")
    private ShirtDesignJpaEntity shirtDesign;

}
