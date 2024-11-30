package com.solohouse.boxes.adapter.out.persistence.jpa.repository;

import com.solohouse.boxes.adapter.out.persistence.jpa.PersistenceMapper;
import com.solohouse.boxes.adapter.out.persistence.jpa.entity.PurchaseJpaEntity;
import com.solohouse.boxes.application.port.out.persistence.PurchaseRepository;
import com.solohouse.boxes.model.Page;
import com.solohouse.boxes.model.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static java.util.Objects.nonNull;

@Repository
@RequiredArgsConstructor
public class PurchaseRepositoryAdapter implements PurchaseRepository {

    private final JpaSpringDataPurchaseRepository jpaSpringDataPurchaseRepository;
    private final PersistenceMapper mapper;


    @Override
    public Optional<Purchase> getById(final Integer purchaseId) {

        return this.jpaSpringDataPurchaseRepository.findById(purchaseId)
                .map(this.mapper::map);
    }

    @Override
    public Purchase save(final Purchase purchase) {

        final PurchaseJpaEntity purchaseJpaEntity = this.mapper.map(purchase);
        final PurchaseJpaEntity savedPurchase = this.jpaSpringDataPurchaseRepository.save(purchaseJpaEntity);
        return this.mapper.map(savedPurchase);
    }

    @Override
    public Page<Purchase> findAllByFilters(final Integer userId, final Boolean picked, final Integer size, final Integer page) {

        final PageRequest pageable = PageRequest.of(page, size);
        final org.springframework.data.domain.Page<PurchaseJpaEntity> purchasesPage =
                this.jpaSpringDataPurchaseRepository.findAll(this.buildSpecification(userId, picked), pageable);

        return this.mapper.map(purchasesPage);
    }

    private Specification<PurchaseJpaEntity> buildSpecification(final Integer userId, final Boolean picked) {

        final Specification<PurchaseJpaEntity> userIdSpec = (root, query, builder) ->
                builder.equal(root.get("userId"), userId);

        if (nonNull(picked)) {
            return userIdSpec.and((root, query, builder) ->
                    builder.equal(root.get("picked"), picked));
        }

        return userIdSpec;
    }
}
