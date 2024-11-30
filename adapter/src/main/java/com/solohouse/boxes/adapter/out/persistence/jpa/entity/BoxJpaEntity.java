package com.solohouse.boxes.adapter.out.persistence.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.lang.NonNull;

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

    @NonNull
    private String name;

    private double longitude;

    private double latitude;

    @OneToMany(mappedBy = "box")
    private List<BoxStockJpaEntity> stock;
}
