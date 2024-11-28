package com.solohouse.boxes.adapter.out.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaSpringDataBoxRepository extends JpaRepository<BoxJpaEntity, Integer> {
}
