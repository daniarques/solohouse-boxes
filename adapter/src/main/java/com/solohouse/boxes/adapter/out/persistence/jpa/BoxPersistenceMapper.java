package com.solohouse.boxes.adapter.out.persistence.jpa;

import com.solohouse.boxes.model.Box;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BoxPersistenceMapper {

    @Mapping(target = "location.longitude", source = "longitude")
    @Mapping(target = "location.latitude", source = "latitude")
    Box map(BoxJpaEntity box);
}
