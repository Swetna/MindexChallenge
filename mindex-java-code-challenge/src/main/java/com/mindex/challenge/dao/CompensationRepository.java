/*
Interface created to find the compensation data
based on the id in the mongo database
 */
package com.mindex.challenge.dao;

import com.mindex.challenge.data.CompensationData;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface CompensationRepository extends MongoRepository<CompensationData, String> {
    CompensationData findByCompensationId(String compensationId);
}

