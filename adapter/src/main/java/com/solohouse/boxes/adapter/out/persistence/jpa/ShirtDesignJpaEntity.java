package com.solohouse.boxes.adapter.out.persistence.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "shirt_design")
@Getter
@Setter
public class ShirtDesignJpaEntity {

    @Id
    private Integer id;

    private String team;

    private String style;

    private String image_url;

    @OneToMany(mappedBy = "shirtDesign")
    private List<BoxStockJpaEntity> stock;
}
