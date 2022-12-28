/*
Class created to add methods such as get and post
for HTTP connection and providing the required
control of the compensations created
 */

package com.mindex.challenge.controller;

import com.mindex.challenge.data.CompensationData;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    @Autowired
    private CompensationService compensationService;

    @PostMapping("/compensation")
    public Employee create(@RequestBody CompensationData compensation) {
        LOG.debug("Received compensation create request for [{}]", compensation);

        return compensationService.create(compensation);
    }

    @GetMapping("/compensation/{id}")
    public CompensationData read(@PathVariable String id) {
        LOG.debug("Received employee create request for id [{}]", id);

        return CompensationService.read(id);
    }
}