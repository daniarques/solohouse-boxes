package com.solohouse.boxes;

import com.solohouse.boxes.application.port.in.CreatePurchaseUseCase;
import com.solohouse.boxes.application.port.in.FindBoxesUseCase;
import com.solohouse.boxes.application.port.in.GetBoxUseCase;
import com.solohouse.boxes.application.port.out.persistence.BoxRepository;
import com.solohouse.boxes.application.port.out.persistence.PurchaseRepository;
import com.solohouse.boxes.application.port.out.transaction.TransactionalService;
import com.solohouse.boxes.application.service.CreatePurchaseService;
import com.solohouse.boxes.application.service.FindBoxesService;
import com.solohouse.boxes.application.service.GetBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAppConfig {

    @Autowired
    BoxRepository boxRepository;

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    TransactionalService transactionalService;

    @Bean
    GetBoxUseCase getBoxUseCase() {
        return new GetBoxService(boxRepository);
    }

    @Bean
    FindBoxesUseCase findBoxesUseCase() {
        return new FindBoxesService(boxRepository);
    }

    @Bean
    CreatePurchaseUseCase createPurchaseUseCase() {
        return new CreatePurchaseService(boxRepository, purchaseRepository, transactionalService);
    }
}
