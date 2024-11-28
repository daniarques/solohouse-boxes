package com.solohouse.boxes;

import com.solohouse.boxes.application.port.in.GetBoxUseCase;
import com.solohouse.boxes.application.port.out.persistence.BoxRepository;
import com.solohouse.boxes.application.service.GetBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAppConfig {

    @Autowired
    BoxRepository boxRepository;

    @Bean
    GetBoxUseCase getBoxUseCase() {
        return new GetBoxService(boxRepository);
    }
}
