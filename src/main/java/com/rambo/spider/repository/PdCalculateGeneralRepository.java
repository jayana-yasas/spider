package com.rambo.spider.repository;

import com.rambo.spider.entity.PdCalGeneral;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PdCalculateGeneralRepository extends CrudRepository<PdCalGeneral, Integer> {
    Boolean existsByStage(int stage);

    Boolean existsByStageAndBasis(int stage, String basis);

    PdCalGeneral findByStage(int stage);

    List<PdCalGeneral> findByStageAndBasis(int stage, String basis );
}