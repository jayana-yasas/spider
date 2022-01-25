package com.rambo.spider.repository;

import com.rambo.spider.entity.ReceiptReport;
import org.springframework.data.repository.CrudRepository;
import java.util.Date;
import java.util.List;


public interface ReceiptReportRepository extends CrudRepository<ReceiptReport, String> {
    List<ReceiptReport> findAllByFacilityNoAndDateGreaterThan(String facilityNo, Date date);
}