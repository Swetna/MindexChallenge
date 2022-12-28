/*
Class to define the properities of the reporting structure data
and adding its getter and setter to create objects of the same
 */



package com.mindex.challenge.data;

public class ReportingStructData {
    private int numberOfReports;
    private Employee employee;


    public ReportingStructData(){
        this.numberOfReports = 0;
        this.employee = null;
    }


    public int getNumberOfReports() {
        return numberOfReports;
    }


    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }


    public Employee getEmployee() {
        return employee;
    }


    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    
}
