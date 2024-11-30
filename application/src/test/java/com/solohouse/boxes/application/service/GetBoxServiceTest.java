package com.solohouse.boxes.application.service;

import com.solohouse.boxes.application.port.in.NotFoundException;
import com.solohouse.boxes.application.port.out.persistence.BoxRepository;
import com.solohouse.boxes.model.Box;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class GetBoxServiceTest {

    public static final int BOX_ID = 123;
    public static final Box BOX = Box.builder().build();
    @Mock
    private BoxRepository boxRepository;

    @InjectMocks
    private GetBoxService getBoxService;

    @Test
    void when_getBox_boxFound_should_returnBox() throws NotFoundException {

        given(this.boxRepository.findById(BOX_ID)).willReturn(Optional.of(BOX));

        final Box box = this.getBoxService.getBox(BOX_ID);

        assertThat(box).isEqualTo(BOX);
    }

    @Test
    void when_getBox_boxNotFound_should_throwNotFoundException() throws NotFoundException {

        given(this.boxRepository.findById(BOX_ID)).willReturn(Optional.empty());

        assertThatThrownBy(() -> this.getBoxService.getBox(BOX_ID))
                .isEqualTo(new NotFoundException("Box with id 123 not found"));

    }
}