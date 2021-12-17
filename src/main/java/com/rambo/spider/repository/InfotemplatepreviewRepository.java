package com.rambo.spider.repository;

import com.rambo.spider.entity.Infotemplatepreview;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InfotemplatepreviewRepository  extends CrudRepository<Infotemplatepreview, String> {
    List<Infotemplatepreview> findAllByStateOrderByMonthDesc(int state);
}
