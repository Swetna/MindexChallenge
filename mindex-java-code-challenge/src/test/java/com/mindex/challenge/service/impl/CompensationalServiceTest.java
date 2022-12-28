

package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.CompensationData;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompensationServiceTest {
    private String compensationUrl;
    private String compensationIdUrl;

    @Autowired
    private CompensationService compensationService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Before
    public void setup() {
        compensationUrl = "http://localhost:" + port + "/compensation";
        compensationIdUrl = "http://localhost:" + port + "/compensation/{id}";
    }

    @Test
    public void testCreateRead() {
        CompensationData testComp = new CompensationData();
        testComp.setEmployeeid("16a596ae-edd3-4847-99fe-c4518e82c86f");
        testComp.setSalary(120000.00f);
        testComp.setEffectiveDate(new Date(1622433600));

        CompensationData createdCompensation = restTemplate.postForEntity(compensationUrl, testComp, CompensationData.class).getBody();
        assertCompensationEquivalence(testComp, createdCompensation);

        CompensationData readCompensation = restTemplate.getForEntity(compensationIdUrl, CompensationData.class, createdCompensation.getEmployeeid()).getBody();
        assertCompensationEquivalence(createdCompensation, readCompensation);
    }

    private static void assertCompensationEquivalence(CompensationData expected, CompensationData actual) {
        assertEquals(expected.getEmployeeid(), actual.getEmployeeid());
        assertEquals(expected.getSalary(), actual.getSalary(), 0f);
        assertEquals(expected.getEffectiveDate().compareTo(actual.getEffectiveDate()), 0);
    }
}