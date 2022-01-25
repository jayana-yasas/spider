package com.rambo.spider.repository;

import com.rambo.spider.entity.PdCalSimplified;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PdCalculateSimplifiedRepository extends CrudRepository<PdCalSimplified, Integer> {
    Boolean existsByStage(int stage);

    Boolean existsByStageAndBasis(int stage, String basis);

    PdCalSimplified findByStage(int stage);

    List<PdCalSimplified> findByStageAndBasis(int stage, String basis);
}