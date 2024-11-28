package com.solohouse.boxes.adapter.in.rest;

import com.solohouse.boxes.application.port.in.GetBoxUseCase;
import com.solohouse.boxes.model.Box;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boxes")
@RequiredArgsConstructor
public class GetBoxController {

    private final GetBoxUseCase getBoxUseCase;
    private final BoxRestMapper boxRestMapper;

    @GetMapping("/{boxId}")
    public BoxWebModel getBox(@PathVariable("boxId") @NonNull final Integer boxId) {

        final Box box = getBoxUseCase.getBox(boxId);
        return boxRestMapper.map(box);
    }
}
