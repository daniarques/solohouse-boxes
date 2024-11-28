package com.solohouse.boxes.adapter.in.rest;

import com.solohouse.boxes.model.Box;
import com.solohouse.boxes.model.BoxLocation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoxRestMapper {

    BoxWebModel map(Box box);

    BoxLocationWebModel map(BoxLocation boxLocation);
}
