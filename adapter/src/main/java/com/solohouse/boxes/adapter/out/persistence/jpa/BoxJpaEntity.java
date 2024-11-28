package com.solohouse.boxes.adapter.out.persistence.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "box")
@Getter
@Setter
public class BoxJpaEntity {

    @Id
    private Integer id;

    private String longitude;

    private String latitude;
}
