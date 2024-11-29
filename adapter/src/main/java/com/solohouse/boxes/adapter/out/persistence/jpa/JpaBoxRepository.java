package com.solohouse.boxes.adapter.out.persistence.jpa;

import com.solohouse.boxes.application.port.out.persistence.BoxRepository;
import com.solohouse.boxes.model.Box;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaBoxRepository implements BoxRepository {

    private final JpaSpringDataBoxRepository springDataBoxRepository;
    private final PersistenceMapper mapper;

    @Override
    public Optional<Box> findById(final int id) {

        final Optional<BoxJpaEntity> box = springDataBoxRepository.findById(id);
        return box.map(this.mapper::map);
    }

    @Override
    public List<Box> findBoxesByBoundaries(final Double minLatitude, final Double maxLatitude,
                                           final Double minLongitude, final Double maxLongitude) {

        final List<BoxJpaEntity> boxes = springDataBoxRepository.findBoxesByBoundaries(minLatitude, maxLatitude, minLongitude, maxLongitude);
        return mapper.mapBoxes(boxes);
    }
}
