package com.rambo.spider.repository;

import com.rambo.spider.entity.Datafile;
import com.rambo.spider.entity.Pdcprocess;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DatafileRepository extends CrudRepository<Datafile, String> {

    List<Datafile> findAllByOrderByFacilityNoAscMonthAsc();

    List<Datafile> findByLastIsNotNullAndLastIsNot(String last);

    List<Datafile> findByFirstAndWorstAndLastIsNot(Double first, Double worst,String last);

    @Query(nativeQuery = true, value = "SELECT * FROM datafile a ORDER BY a.facility_no ASC, a.MONTH ASC")
    List<Pdcprocess> O();
}