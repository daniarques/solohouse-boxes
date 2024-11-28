package com.solohouse.boxes.application.service;

import com.solohouse.boxes.application.port.in.FindBoxesUseCase;
import com.solohouse.boxes.application.port.out.persistence.BoxRepository;
import com.solohouse.boxes.model.Box;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindBoxesService implements FindBoxesUseCase {

    private final BoxRepository boxRepository;

    @Override
    public List<Box> findBoxes(final Double minLatitude, final Double maxLatitude,
                               final Double minLongitude, final Double maxLongitude) {

        return boxRepository.findBoxesByBoundaries(minLatitude, maxLatitude, minLongitude, maxLongitude);
    }
}
