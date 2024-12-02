package com.solohouse.boxes.application.service;

import com.solohouse.boxes.application.port.in.FindBoxesUseCase;
import com.solohouse.boxes.application.port.out.persistence.BoxRepository;
import com.solohouse.boxes.model.Box;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
public class FindBoxesService implements FindBoxesUseCase {

    private final BoxRepository boxRepository;

    @Override
    public List<Box> findBoxes(final Double minLatitude, final Double maxLatitude,
                               final Double minLongitude, final Double maxLongitude,
                               final Boolean expand) {

        return this.boxRepository.findBoxesByBoundaries(minLatitude, maxLatitude, minLongitude, maxLongitude, TRUE.equals(expand));
    }
}
