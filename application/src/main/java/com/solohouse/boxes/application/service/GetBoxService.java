package com.solohouse.boxes.application.service;

import com.solohouse.boxes.application.port.in.GetBoxUseCase;
import com.solohouse.boxes.application.port.in.NotFoundException;
import com.solohouse.boxes.application.port.out.persistence.BoxRepository;
import com.solohouse.boxes.model.Box;
import lombok.RequiredArgsConstructor;

import static java.lang.String.format;

@RequiredArgsConstructor
public class GetBoxService implements GetBoxUseCase {

    private final BoxRepository boxRepository;

    @Override
    public Box getBox(final int id) {

        return boxRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(format("Box with id %s not found", id)));
    }
}
