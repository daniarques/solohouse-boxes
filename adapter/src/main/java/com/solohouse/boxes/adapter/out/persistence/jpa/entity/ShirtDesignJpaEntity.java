package com.solohouse.boxes.adapter.out.persistence.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "shirt_design")
public class ShirtDesignJpaEntity {

    @Id
    private Integer id;

    private String team;

    private String style;

    private String image_url;

    @OneToMany(mappedBy = "shirtDesign")
    private List<BoxStockJpaEntity> stock;
}
