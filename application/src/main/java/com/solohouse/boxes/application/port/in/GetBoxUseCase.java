package com.solohouse.boxes.application.port.in;

import com.solohouse.boxes.model.Box;

public interface GetBoxUseCase {

    Box getBox(int id);
}
