package com.trackensure.finaltask.integration.valueobject;

public class SalaryType {
    private int salaryTypeId;
    private String salaryTypeName;

    public SalaryType(int salaryTypeId, String salaryTypeName) {
        this.salaryTypeId = salaryTypeId;
        this.salaryTypeName = salaryTypeName;
    }

    public SalaryType(String salaryTypeName) {
        this.salaryTypeName = salaryTypeName;
    }

    public SalaryType() {
    }

    public int getSalaryTypeId() {
        return salaryTypeId;
    }

    public String getSalaryTypeName() {
        return salaryTypeName;
    }
}
