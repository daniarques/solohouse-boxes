package com.solohouse.boxes.adapter.out.persistence.jpa.repository;

import com.solohouse.boxes.adapter.out.persistence.jpa.PersistenceMapperImpl;
import com.solohouse.boxes.adapter.out.persistence.jpa.entity.BoxJpaEntity;
import com.solohouse.boxes.adapter.out.persistence.jpa.entity.BoxStockJpaEntity;
import com.solohouse.boxes.adapter.out.persistence.jpa.entity.BoxStockPKJpaEntity;
import com.solohouse.boxes.adapter.out.persistence.jpa.entity.ShirtDesignJpaEntity;
import com.solohouse.boxes.application.port.out.persistence.EntityNotFoundException;
import com.solohouse.boxes.model.Box;
import com.solohouse.boxes.model.BoxLocation;
import com.solohouse.boxes.model.ShirtDesign;
import com.solohouse.boxes.model.ShirtLine;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class BoxRepositoryAdapterTest {

    public static final int ID = 123;
    public static final String NAME = "Box 1";
    public static final Double LONGITUDE = 1.1;
    public static final Double LATITUDE = 2.2;
    public static final BoxJpaEntity BOX_ENTITY = BoxJpaEntity.builder()
            .id(ID)
            .name(NAME)
            .longitude(LONGITUDE)
            .latitude(LATITUDE)
            .build();
    public static final int SHIRT_DESIGN_ID = 111;
    public static final int AVAILABLE_AMOUNT = 200;
    public static final int REAL_AMOUNT = 10;
    public static final double PRICE = 20.2;
    public static final String TEAM = "Team";
    public static final String STYLE = "Primary";
    public static final String IMAGE_URL = "image.com";
    public static final BoxStockPKJpaEntity BOX_STOCK_PK_ENTITY = BoxStockPKJpaEntity.builder()
            .boxId(ID)
            .shirtDesignId(SHIRT_DESIGN_ID)
            .build();
    public static final BoxStockJpaEntity BOX_STOCK_ENTITY = BoxStockJpaEntity.builder()
            .id(BOX_STOCK_PK_ENTITY)
            .availableAmount(AVAILABLE_AMOUNT)
            .realAmount(REAL_AMOUNT)
            .price(PRICE)
            .shirtDesign(ShirtDesignJpaEntity.builder()
                    .id(SHIRT_DESIGN_ID)
                    .team(TEAM)
                    .style(STYLE)
                    .image_url(IMAGE_URL)
                    .build())
            .build();
    public static final BoxJpaEntity BOX_ENTITY_WITH_JOINS = BoxJpaEntity.builder()
            .id(ID)
            .name(NAME)
            .longitude(LONGITUDE)
            .latitude(LATITUDE)
            .stock(List.of(BOX_STOCK_ENTITY))
            .build();
    public static final Double MIN_LATITUDE = 0.1;
    public static final Double MAX_LATITUDE = 0.2;
    public static final Double MAX_LONGITUDE = 10.2;
    public static final Double MIN_LONGITUDE = 10.1;
    @Mock
    private JpaSpringDataBoxRepository jpaSpringDataBoxRepository;

    @Mock
    private JpaSpringDataBoxStockRepository jpaSpringDataBoxStockRepository;

    @Spy
    private PersistenceMapperImpl mapper;

    @InjectMocks
    private BoxRepositoryAdapter boxRepositoryAdapter;

    @Test
    void when_findById_should_returnBox() {

        given(this.jpaSpringDataBoxRepository.findById(ID)).willReturn(Optional.of(BOX_ENTITY));

        final Optional<Box> actual = this.boxRepositoryAdapter.findById(ID, true);

        final Box expectedBox = Box.builder()
                .id(ID)
                .name(NAME)
                .location(BoxLocation.builder()
                        .longitude(LONGITUDE)
                        .latitude(LATITUDE)
                        .build())
                .build();

        assertThat(actual).get()
                .isEqualTo(expectedBox);
    }

    @Test
    void when_findBoxesByBoundaries_should_returnBoxes() {

        given(this.jpaSpringDataBoxRepository.findBoxesByBoundaries(MIN_LATITUDE, MAX_LATITUDE, MIN_LONGITUDE, MAX_LONGITUDE)).willReturn(List.of(BOX_ENTITY_WITH_JOINS));

        final List<Box> boxes = this.boxRepositoryAdapter.findBoxesByBoundaries(MIN_LATITUDE, MAX_LATITUDE, MIN_LONGITUDE, MAX_LONGITUDE);

        final Box expectedBox = Box.builder()
                .id(ID)
                .name(NAME)
                .location(BoxLocation.builder()
                        .longitude(LONGITUDE)
                        .latitude(LATITUDE)
                        .build())
                .shirts(List.of(ShirtLine.builder()
                        .shirtDesign(ShirtDesign.builder()
                                .id(SHIRT_DESIGN_ID)
                                .teamName(TEAM)
                                .style(STYLE)
                                .imageUrl(IMAGE_URL)
                                .build())
                        .amount(AVAILABLE_AMOUNT)
                        .price(PRICE)
                        .build()))
                .build();

        assertThat(boxes).first()
                .usingRecursiveComparison()
                .isEqualTo(expectedBox);
    }

    @Test
    void when_isShirtDesignAvailableInBox_should_returnTrue() throws EntityNotFoundException {

        given(this.jpaSpringDataBoxStockRepository.findById(BOX_STOCK_PK_ENTITY)).willReturn(Optional.of(BOX_STOCK_ENTITY));

        this.boxRepositoryAdapter.decreaseShirtDesignAmountFromBox(ID, SHIRT_DESIGN_ID);

        then(this.jpaSpringDataBoxStockRepository).should().save(BOX_STOCK_ENTITY.toBuilder()
                .availableAmount(AVAILABLE_AMOUNT - 1)
                .build());
    }

    @Test
    void when_isShirtDesignAvailableInBox_notFoundBoxStock_should_failEntityNotFound() {

        given(this.jpaSpringDataBoxStockRepository.findById(BOX_STOCK_PK_ENTITY)).willReturn(Optional.empty());

        assertThatThrownBy(() -> this.boxRepositoryAdapter.decreaseShirtDesignAmountFromBox(ID, SHIRT_DESIGN_ID))
                .isInstanceOf(EntityNotFoundException.class);
    }
}