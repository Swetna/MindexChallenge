/**
 * Function to generate the reporting structure values
 * and count them
 */

package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructData;
import com.mindex.challenge.service.ReportingStruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReportStructServiceImpl implements ReportingStruct{

    private static final Logger LOG = LoggerFactory.getLogger(ReportStructServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ReportingStructData generateReportingStructData(String id)
    {
        LOG.debug("Creating reports for employee id[{}]", id);

        Employee EmpNode = employeeRepository.findByEmployeeId(id);

        if(EmpNode == null){
            throw Exception("No employee found: "+id);
        }

        int numberOfReports = 0;

        // Creating report object
        ReportingStructData report = new ReportingStructData();

        List<Employee> directReport = EmpNode.getDirectReports();

//        Adding the value of directReports to count
        numberOfReports = directReport.size();


        for(Employee employee : directReport){
            List<Employee> directReportSubEmps = employee.getDirectReports();
            if(directReportSubEmps!=null){

//                Adding the count of all the distinct reports
                numberOfReports += directReportSubEmps.size();
            }
        }

        report.setNumberOfReports(numberOfReports);
       

        return report;
    }
    
}
