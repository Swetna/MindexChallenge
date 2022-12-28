

package com.mindex.challenge.service;

import com.mindex.challenge.data.CompensationData;


public interface CompensationService {
    CompensationData create(CompensationData employee);
    CompensationData read(String id);
}
