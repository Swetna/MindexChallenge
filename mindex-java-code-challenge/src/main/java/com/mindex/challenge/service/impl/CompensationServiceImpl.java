/**
 * Class to create or read compensation data
 */

package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.CompensationData;
import com.mindex.challenge.service.CompensationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class CompensationServiceImpl implements CompensationService {

    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    private CompensationRepository compensationRepository;

    @Override
    public CompensationData create(CompensationData compensation) {
        LOG.debug("Creating compensation[{}]", compensation);


        compensationRepository.insert(compensation);

        return compensation;
    }

    @Override
    public CompensationData read(String id) {
        LOG.debug("Creating employee with id [{}]", id);

        CompensationData compensation = compensationRepository.findByCompensationId(id);

        if (compensation == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return compensation;
    }
}
