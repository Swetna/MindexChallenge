// package com.mindex.challenge.service.impl;

// public class ReprtStructServiceImplTest {
    
// }


package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructData;
import com.mindex.challenge.service.ReportingStruct;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReprtStructServiceImplTest {

    private String reportingUrl;


    @Autowired
    private ReportingStruct reportService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
        reportingUrl = "http://localhost:" + port + "/report/{id}";

    }

    @Test
    public void testReport() {
        String targetEmployeeID = "16a596ae-edd3-4847-99fe-c4518e82c86f";
        ReportingStructData report = restTemplate.getForEntity(reportingUrl, ReportingStructData.class, targetEmployeeID).getBody();
        assertEquals(4, report.getNumberOfReports());
    }

        @Test
        public void testReportingEmployee() {
            String employeeId = "c0c2293d-16bd-4603-8e08-638a9d18b22c";
            ReportingStructData report = restTemplate.getForEntity(reportingUrl, ReportingStructData.class, employeeId).getBody();

            //Create expected Employee
            Employee expectedEmployee = new Employee();
            expectedEmployee.setFirstName("George");
            expectedEmployee.setLastName("Harrison");
            expectedEmployee.setDepartment("Engineering");
            expectedEmployee.setPosition("Developer III");

            assertEmployeeEquivalence(expectedEmployee, report.getEmployee());
        }




    private static void assertEmployeeEquivalence(Employee expected, Employee actual) {
        assertEquals(expected.getFirstName(), actual.getFirstName());
        assertEquals(expected.getLastName(), actual.getLastName());
        assertEquals(expected.getDepartment(), actual.getDepartment());
        assertEquals(expected.getPosition(), actual.getPosition());
        assertEquals(expected.getDirectReports(), actual.getDirectReports());
    }
}