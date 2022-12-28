/*
Class to define the properitites of the compensation data
and adding its getter and setter to create objects of the same
 */
package com.mindex.challenge.data;

import java.util.Date;

public class CompensationData {

    private String employeeid;
    private float salary;

    @JsonFormat (pattern = "MM/dd/yyyy")
    private Date effectiveDate;


    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public CompensationData(){

    }


}
