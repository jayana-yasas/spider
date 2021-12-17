package com.rambo.spider.repository;

import com.rambo.spider.entity.Matrix;
import com.rambo.spider.entity.Pdcprocess;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;


public interface MatrixRepository extends CrudRepository<Matrix, Integer> {



}