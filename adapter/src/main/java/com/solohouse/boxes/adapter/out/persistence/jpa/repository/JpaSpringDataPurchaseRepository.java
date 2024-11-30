package com.solohouse.boxes.adapter.out.persistence.jpa.repository;

import com.solohouse.boxes.adapter.out.persistence.jpa.entity.PurchaseJpaEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaSpringDataPurchaseRepository extends CrudRepository<PurchaseJpaEntity, Integer>, JpaSpecificationExecutor<PurchaseJpaEntity> {

}
