package com.solohouse.boxes.adapter.in.rest;

import com.solohouse.boxes.adapter.in.rest.model.BoxWebModel;
import com.solohouse.boxes.adapter.in.rest.model.BoxWithShirtsWebModel;
import com.solohouse.boxes.application.port.in.FindBoxesUseCase;
import com.solohouse.boxes.application.port.in.GetBoxUseCase;
import com.solohouse.boxes.model.Box;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boxes")
@RequiredArgsConstructor
public class BoxController {

    private final GetBoxUseCase getBoxUseCase;
    private final FindBoxesUseCase findBoxesUseCase;
    private final BoxRestMapper boxRestMapper;

    @Operation(summary = "Get box by ID",
            description = "Get a box by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the box"),
            @ApiResponse(responseCode = "404", description = "Box not found")
    })
    @GetMapping("/{boxId}")
    public BoxWebModel getBox(@PathVariable("boxId") @NonNull final Integer boxId,
                              @RequestParam(required = false) Boolean expand) {

        final Box box = this.getBoxUseCase.getBox(boxId, expand);
        return this.boxRestMapper.map(box);
    }

    @Operation(summary = "Find boxes in area",
            description = "Find boxes in area delimited by minLatitude/maxLatitude and minLongitude/maxLongitude")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Boxes found")
    })
    @GetMapping
    public List<BoxWithShirtsWebModel> findBoxes(@RequestParam("minLatitude") @NonNull final Double minLatitude,
                                                 @RequestParam("maxLatitude") @NonNull final Double maxLatitude,
                                                 @RequestParam("minLongitude") @NonNull final Double minLongitude,
                                                 @RequestParam("maxLongitude") @NonNull final Double maxLongitude,
                                                 @RequestParam(value = "expand", required = false) @NonNull final Boolean expand) {

        final List<Box> boxes = this.findBoxesUseCase.findBoxes(minLatitude, maxLatitude, minLongitude, maxLongitude, expand);
        return this.boxRestMapper.mapToBoxesWithShirts(boxes);
    }
}
