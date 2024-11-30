package com.solohouse.boxes.adapter.out.persistence.jpa.repository;

import com.solohouse.boxes.adapter.out.persistence.jpa.PersistenceMapper;
import com.solohouse.boxes.adapter.out.persistence.jpa.entity.BoxJpaEntity;
import com.solohouse.boxes.adapter.out.persistence.jpa.entity.BoxStockJpaEntity;
import com.solohouse.boxes.adapter.out.persistence.jpa.entity.BoxStockPKJpaEntity;
import com.solohouse.boxes.application.port.out.persistence.BoxRepository;
import com.solohouse.boxes.application.port.out.persistence.EntityNotFoundException;
import com.solohouse.boxes.model.Box;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoxRepositoryAdapter implements BoxRepository {

    private final JpaSpringDataBoxRepository jpaSpringDataBoxRepository;
    private final JpaSpringDataBoxStockRepository jpaSpringDataBoxStockRepository;
    private final PersistenceMapper mapper;

    @Override
    public Optional<Box> findById(final int id) {

        //TODO: is fetching eager
        final Optional<BoxJpaEntity> box = this.jpaSpringDataBoxRepository.findById(id);
        return box.map(this.mapper::map);
    }

    @Override
    public List<Box> findBoxesByBoundaries(final Double minLatitude, final Double maxLatitude,
                                           final Double minLongitude, final Double maxLongitude) {

        final List<BoxJpaEntity> boxes = this.jpaSpringDataBoxRepository.findBoxesByBoundaries(minLatitude, maxLatitude, minLongitude, maxLongitude);
        return this.mapper.mapBoxes(boxes);
    }


    @Override
    public void decreaseShirtDesignAmountFromBox(final int boxId, final int shirtDesignId) throws EntityNotFoundException {

        //TODO: is fetching eager
        final BoxStockJpaEntity boxStock = this.jpaSpringDataBoxStockRepository.findById(this.buildPK(boxId, shirtDesignId))
                .orElseThrow(EntityNotFoundException::new);

        this.jpaSpringDataBoxStockRepository.save(this.decreaseAmount(boxStock));
    }

    private BoxStockJpaEntity decreaseAmount(final BoxStockJpaEntity boxStock) {

        return boxStock.toBuilder()
                .availableAmount(boxStock.getAvailableAmount() - 1)
                .build();
    }

    private BoxStockPKJpaEntity buildPK(final int boxId, final int shirtDesignId) {

        final BoxStockPKJpaEntity boxStockPKJpaEntity = new BoxStockPKJpaEntity();
        boxStockPKJpaEntity.setBoxId(boxId);
        boxStockPKJpaEntity.setShirtDesignId(shirtDesignId);
        return boxStockPKJpaEntity;
    }

}
