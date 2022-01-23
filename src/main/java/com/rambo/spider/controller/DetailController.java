package com.rambo.spider.controller;

import com.rambo.spider.listener.GeneralFileReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetailController {
    @Value(value = "${spring.datasource.url}")
    String spring_datasource_url;
    @GetMapping("/")
    public String sayHello() {
         String details=
                 "<br>Spider is <b>running</b>" +
                 "<br>Version No : <b>V1.00</b>" +
                 "<br>Deployed date & time : <b>" + GeneralFileReader.deployedDate +"</b>";
       String details1=
                 "<table style=\"width:80%\">" +

                         "<tr>" +
                         "    <td>Version</td>" +
                         "    <td><b>V1.00</b></td>" +
                         "  </tr> " +
                         "<tr>" +
                         "    <td>Status</td>" +
                         "    <td>Running</td>" +
                         "  </tr> " +
                         "<tr>" +
                         "    <td>Depolyed Datetime</td>" +
                         "    <td>"+ GeneralFileReader.deployedDate+"</td>" +
                         "  </tr> " +
                         "<tr>" +
                         "    <td>Database</td>" +
                         "    <td>"+spring_datasource_url+"</td>" +
                         "  </tr> " +
                         "<tr>" +
                         "</table>";
        return details1;
    }
}
