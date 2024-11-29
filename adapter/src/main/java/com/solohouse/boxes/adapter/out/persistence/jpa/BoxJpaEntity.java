package com.solohouse.boxes.adapter.out.persistence.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "box")
@Getter
@Setter
public class BoxJpaEntity {

    @Id
    private Integer id;

    private String name;

    private Double longitude;

    private Double latitude;

    @OneToMany(mappedBy = "box")
    private List<BoxStockJpaEntity> stock;
}
