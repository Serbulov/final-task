package com.trackensure.finaltask.integration.valueobject;

public class Department {
    private int departmentId;
    private String departmentName;

    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department() {
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
