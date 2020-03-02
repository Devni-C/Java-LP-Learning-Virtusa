package com.devni.tlp.employeeservice.shared_model;

public class Allocation {
    Integer id;

    Integer empId;
    String startDate;
    String endDate;
    String projectCode;

    public Allocation() {
    }

    public Allocation(Integer empId, String startDate, String endDate, String projectCode) {
        this.empId = empId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectCode = projectCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }
}
