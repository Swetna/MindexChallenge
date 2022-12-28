/*

Class created to add methods for get and post
for HTTP connection and providing the required
control of the repository structure created
 */

package com.mindex.challenge.controller;

import com.mindex.challenge.data.ReportStructData;
import com.mindex.challenge.service.ReportingStruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class ReportStructController {
    
    private static final Logger LOG = LoggerFactory.getLogger(ReportStructController.class);

    @Autowired
    private ReportingStruct reportingService;

    @GetMapping("/report/{id}")
    public ReportingStruct generateReportStruct(@PathVariable String id) {
        LOG.debug("Received reports creation request for id [{}]", id);

        return reportingService.generateReportStruct(id);
    }





}
