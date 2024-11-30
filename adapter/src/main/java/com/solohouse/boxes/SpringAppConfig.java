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
    CreateShirtPurchaseUseCase createPurchaseUseCase() {
        return new CreateShirtShirtPurchaseService(this.boxRepository, this.purchaseRepository, this.transactionalService);
    }

    @Bean
    PickShirtPurchaseUseCase pickPurchaseUseCase() {
        return new PickShirtShirtPurchaseService(this.purchaseRepository);
    }

    @Bean
    SearchShirtPurchasesUseCase searchPurchasesUseCase() {
        return new SearchShirtShirtPurchasesService(this.purchaseRepository);
    }
}
