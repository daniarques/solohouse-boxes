package com.solohouse.boxes.adapter.in.rest;

import com.solohouse.boxes.model.Box;
import com.solohouse.boxes.model.BoxLocation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoxRestMapper {

    BoxWebModel map(Box box);

    List<BoxWebModel> mapBoxes(List<Box> box);

    BoxLocationWebModel map(BoxLocation boxLocation);

}
