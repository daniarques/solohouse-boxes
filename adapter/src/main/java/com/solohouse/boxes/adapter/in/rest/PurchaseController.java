package com.solohouse.boxes.adapter.in.rest;

import com.solohouse.boxes.application.port.in.CreatePurchaseUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boxes/{id}/shirts/{shirtId}/purchase")
@RequiredArgsConstructor
public class PurchaseController {

    private final CreatePurchaseUseCase createPurchaseUseCase;

    @Operation(summary = "Purchase shirt",
            description = "Purchase a single shirt found in a particular box")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Purchase created"),
            @ApiResponse(responseCode = "400", description = "Unable to create desired purchase")
    })
    @PostMapping
    public void createPurchase(@PathVariable("id") @NonNull final Integer boxId,
                               @PathVariable("shirtId") @NonNull final Integer shirtId,
                               //TODO: user sent via header token with OAuth
                               @RequestParam("user") @NonNull final Integer userId) {

        createPurchaseUseCase.createPurchase(boxId, shirtId, userId);
    }
}
