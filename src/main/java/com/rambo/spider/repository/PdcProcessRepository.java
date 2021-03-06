package com.rambo.spider.repository;

import com.rambo.spider.entity.Pdcprocess;
import org.springframework.data.repository.CrudRepository;

public interface PdcProcessRepository extends CrudRepository<Pdcprocess, Integer> {
    Boolean existsByStage(int stage);

    Boolean existsByStageAndBasis(int stage, String basis);

    Pdcprocess findByStage(int stage);

    Pdcprocess findByStageAndBasis(int stage,String basis);
}