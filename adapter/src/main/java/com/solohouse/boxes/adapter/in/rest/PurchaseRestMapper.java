package com.solohouse.boxes.adapter.in.rest;

import com.solohouse.boxes.adapter.in.rest.model.PurchaseWebModel;
import com.solohouse.boxes.model.Purchase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PurchaseRestMapper {

    @Mapping(target = "shirtDesignId", source = "shirtId")
    Purchase map(PurchaseWebModel purchaseWebModel);
}
