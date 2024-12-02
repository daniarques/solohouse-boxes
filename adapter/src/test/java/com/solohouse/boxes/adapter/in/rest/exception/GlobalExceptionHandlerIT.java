package com.solohouse.boxes.adapter.in.rest.exception;


import com.solohouse.boxes.adapter.in.rest.BoxController;
import com.solohouse.boxes.application.port.in.InvalidParameterException;
import com.solohouse.boxes.application.port.in.NotFoundException;
import com.solohouse.boxes.application.service.GetBoxService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = BoxController.class)
class GlobalExceptionHandlerIT {

    private static final int BOX_ID = 1;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetBoxService getBoxService;

    @Test
    void when_apiCallThrowsInvalidParameterException_should_return404() throws Exception {

        given(this.getBoxService.getBox(BOX_ID, expand)).willThrow(new InvalidParameterException("msg"));

        this.mockMvc.perform(get("/boxes/1"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.timestamp").exists())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.error").value("msg"))
                .andExpect(jsonPath("$.path").value("/boxes/1"));
    }

    @Test
    void when_apiCallThrowsNotFoundException_should_return404() throws Exception {

        given(this.getBoxService.getBox(BOX_ID, expand)).willThrow(new NotFoundException("msg"));

        this.mockMvc.perform(get("/boxes/1"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.timestamp").exists())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.error").value("msg"))
                .andExpect(jsonPath("$.path").value("/boxes/1"));
    }

}