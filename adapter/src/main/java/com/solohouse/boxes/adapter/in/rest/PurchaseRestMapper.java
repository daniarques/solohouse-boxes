package com.solohouse.boxes.adapter.in.rest;

import com.solohouse.boxes.adapter.in.rest.model.CreatePurchaseWebModel;
import com.solohouse.boxes.adapter.in.rest.model.PageWebModel;
import com.solohouse.boxes.adapter.in.rest.model.PurchaseWebModel;
import com.solohouse.boxes.model.Page;
import com.solohouse.boxes.model.Purchase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PurchaseRestMapper {

    @Mapping(target = "shirtDesignId", source = "shirtId")
    Purchase map(CreatePurchaseWebModel createPurchaseWebModel);

    @Mapping(target = "shirtId", source = "shirtDesignId")
    PurchaseWebModel map(Purchase purchase);

    PageWebModel<PurchaseWebModel> map(Page<Purchase> purchasesPage);
}
