package com.solohouse.boxes.adapter.out.persistence.jpa.repository;

import com.solohouse.boxes.adapter.out.persistence.jpa.entity.BoxStockJpaEntity;
import com.solohouse.boxes.adapter.out.persistence.jpa.entity.BoxStockPKJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaSpringDataBoxStockRepository extends JpaRepository<BoxStockJpaEntity, BoxStockPKJpaEntity> {

}
