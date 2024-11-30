package com.solohouse.boxes.adapter.out.persistence.jpa;

import com.solohouse.boxes.adapter.out.persistence.jpa.entity.BoxJpaEntity;
import com.solohouse.boxes.adapter.out.persistence.jpa.entity.BoxStockJpaEntity;
import com.solohouse.boxes.adapter.out.persistence.jpa.entity.PurchaseJpaEntity;
import com.solohouse.boxes.adapter.out.persistence.jpa.entity.ShirtDesignJpaEntity;
import com.solohouse.boxes.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersistenceMapper {

    @Mapping(target = "location.longitude", source = "longitude")
    @Mapping(target = "location.latitude", source = "latitude")
    @Mapping(target = "shirts", source = "stock")
    Box map(BoxJpaEntity box);

    @Mapping(target = "amount", source = "availableAmount")
    ShirtLine map(BoxStockJpaEntity stock);

    @Mapping(target = "teamName", source = "team")
    @Mapping(target = "imageUrl", source = "image_url")
    ShirtDesign map(ShirtDesignJpaEntity stock);

    List<Box> mapBoxes(List<BoxJpaEntity> box);

    PurchaseJpaEntity map(Purchase purchase);

    Purchase map(PurchaseJpaEntity purchaseEntity);

    @Mapping(target = "page", source = "number")
    @Mapping(target = "content", source = "content", defaultExpression = "java(java.util.List.of())")
    Page<Purchase> map(org.springframework.data.domain.Page<PurchaseJpaEntity> purchaseEntity);

}
