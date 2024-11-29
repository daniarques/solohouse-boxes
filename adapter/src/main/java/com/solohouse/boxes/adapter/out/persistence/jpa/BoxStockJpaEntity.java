package com.solohouse.boxes.adapter.out.persistence.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "box_stock")
@Getter
@Setter
public class BoxStockJpaEntity {

    @Id
    @Embedded
    BoxStockPKJpaEntity id;

    @Column(name = "available_amount")
    private Integer availableAmount;

    @Column(name = "real_amount")
    private Integer realAmount;

    private Double price;

    @ManyToOne
    @MapsId("boxId")
    @JoinColumn(name = "box_id")
    private BoxJpaEntity box;

    @ManyToOne
    @MapsId("shirtDesignId")
    @JoinColumn(name = "shirt_design_id")
    private ShirtDesignJpaEntity shirtDesign;

}
