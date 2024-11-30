package com.solohouse.boxes.adapter.out.persistence.jpa.repository;

import com.solohouse.boxes.adapter.out.persistence.jpa.PersistenceMapper;
import com.solohouse.boxes.adapter.out.persistence.jpa.entity.PurchaseJpaEntity;
import com.solohouse.boxes.application.port.out.persistence.PurchaseRepository;
import com.solohouse.boxes.model.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PurchaseRepositoryAdapter implements PurchaseRepository {

    private final JpaSpringDataPurchaseRepository jpaSpringDataPurchaseRepository;
    private final PersistenceMapper mapper;


    @Override
    public void create(final Purchase purchase) {

        final PurchaseJpaEntity purchaseJpaEntity = this.mapper.map(purchase);
        this.jpaSpringDataPurchaseRepository.save(purchaseJpaEntity);
    }
}
