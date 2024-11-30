package com.solohouse.boxes.adapter.out.persistence.jpa.repository;

import com.solohouse.boxes.adapter.out.persistence.jpa.entity.BoxJpaEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaSpringDataBoxRepository extends JpaRepository<BoxJpaEntity, Integer> {

    //TODO: Add limit N and order by most used boxes
    @EntityGraph(attributePaths = {
            "stock", "stock.shirtDesign"
    })
    @Query("""
            SELECT b FROM BoxJpaEntity b
            WHERE b.latitude between ?1 and ?2
            and b.longitude between ?3 and ?4""")
    List<BoxJpaEntity> findBoxesByBoundaries(Double minLatitude, Double maxLatitude,
                                             Double minLongitude, Double maxLongitude);

}
