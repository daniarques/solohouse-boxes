package com.solohouse.boxes.application.port.in;

import com.solohouse.boxes.model.Box;

import java.util.List;

public interface FindBoxesUseCase {

    List<Box> findBoxes(Double minLatitude, Double maxLatitude, Double minLongitude, Double maxLongitude, Boolean expand);

}
