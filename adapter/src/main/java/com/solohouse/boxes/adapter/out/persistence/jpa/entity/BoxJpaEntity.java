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
@Table(name = "box")
public class BoxJpaEntity {

    @Id
    private Integer id;

    private String name;

    private Double longitude;

    private Double latitude;

    @OneToMany(mappedBy = "box")
    private List<BoxStockJpaEntity> stock;
}
