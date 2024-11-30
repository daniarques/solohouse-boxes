package com.solohouse.boxes.adapter.out.persistence.jpa;

import com.solohouse.boxes.adapter.out.persistence.jpa.entity.BoxJpaEntity;
import com.solohouse.boxes.model.Box;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LazyPersistenceMapper {

    @Mapping(target = "location.longitude", source = "longitude")
    @Mapping(target = "location.latitude", source = "latitude")
    @Mapping(target = "shirts", ignore = true)
    Box mapLazy(BoxJpaEntity box);

}
