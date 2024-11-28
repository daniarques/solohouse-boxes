package com.solohouse.boxes.application.port.out.persistence;

import com.solohouse.boxes.model.Box;

import java.util.List;
import java.util.Optional;

public interface BoxRepository {

    Optional<Box> findById(int id);

    List<Box> findBoxesByBoundaries(Double minLatitude, Double maxLatitude, Double minLongitude, Double maxLongitude);
}
