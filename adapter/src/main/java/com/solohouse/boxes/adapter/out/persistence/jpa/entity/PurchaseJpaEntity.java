package com.solohouse.boxes.adapter.out.persistence.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "purchase")
public class PurchaseJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "shirt_design_id")
    private int shirtDesignId;

    @Column(name = "box_id")
    private int boxId;

    @Column(name = "user_id")
    private int userId;

    @Builder.Default
    private boolean picked = false;

    @Column(name = "created_at")
    @Builder.Default
    private Timestamp createdAt = Timestamp.from(Instant.now());

    @Column(name = "picked_at")
    private Timestamp pickedAt;

}
