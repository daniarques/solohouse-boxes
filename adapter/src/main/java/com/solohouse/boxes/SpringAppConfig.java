package com.solohouse.boxes;

import com.solohouse.boxes.application.port.in.*;
import com.solohouse.boxes.application.port.out.persistence.BoxRepository;
import com.solohouse.boxes.application.port.out.persistence.PurchaseRepository;
import com.solohouse.boxes.application.port.out.transaction.TransactionalService;
import com.solohouse.boxes.application.service.*;
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
        return new GetBoxService(this.boxRepository);
    }

    @Bean
    FindBoxesUseCase findBoxesUseCase() {
        return new FindBoxesService(this.boxRepository);
    }

    @Bean
    CreatePurchaseUseCase createPurchaseUseCase() {
        return new CreatePurchaseService(this.boxRepository, this.purchaseRepository, this.transactionalService);
    }

    @Bean
    PickPurchaseUseCase pickPurchaseUseCase() {
        return new PickPurchaseService(this.purchaseRepository);
    }

    @Bean
    SearchPurchasesUseCase searchPurchasesUseCase() {
        return new SearchPurchasesService(this.purchaseRepository);
    }
}
