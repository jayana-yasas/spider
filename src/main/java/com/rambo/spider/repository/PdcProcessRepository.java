package com.rambo.spider.repository;

import com.rambo.spider.entity.Pdcprocess;
import org.springframework.data.repository.CrudRepository;


public interface PdcProcessRepository extends CrudRepository<Pdcprocess, Integer> {
    Boolean existsByStage(int stage);
}