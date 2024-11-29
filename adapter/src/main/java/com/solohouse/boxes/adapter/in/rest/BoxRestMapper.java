package com.solohouse.boxes.adapter.in.rest;

import com.solohouse.boxes.adapter.in.rest.model.BoxLocationWebModel;
import com.solohouse.boxes.adapter.in.rest.model.BoxShirtWebModel;
import com.solohouse.boxes.adapter.in.rest.model.BoxWebModel;
import com.solohouse.boxes.adapter.in.rest.model.BoxWithShirtsWebModel;
import com.solohouse.boxes.model.Box;
import com.solohouse.boxes.model.BoxLocation;
import com.solohouse.boxes.model.ShirtLine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoxRestMapper {

    BoxWebModel map(Box box);

    BoxLocationWebModel map(BoxLocation boxLocation);

    @Mapping(target = "availableShirts", source = "shirts")
    BoxWithShirtsWebModel mapToBoxWithShirts(Box box);

    List<BoxWithShirtsWebModel> mapToBoxesWithShirts(List<Box> box);

    @Mapping(target = "id", source = "shirtDesign.id")
    @Mapping(target = "team", source = "shirtDesign.teamName")
    @Mapping(target = "style", source = "shirtDesign.style")
    @Mapping(target = "imageUrl", source = "shirtDesign.imageUrl")
    BoxShirtWebModel map(ShirtLine shirtLine);

    List<BoxShirtWebModel> map(List<ShirtLine> shirtLine);

}
