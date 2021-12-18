package com.trackensure.finaltask.integration.valueobject;

public class WorkingHours {
    private int employeeId;
    private int roleId;
    private int departmentId;
    private int preferenceWT;
    private int currentWT;

    public WorkingHours(int employeeId, int roleId, int departmentId, int preferenceWT, int currentWT) {
        this.employeeId = employeeId;
        this.roleId = roleId;
        this.departmentId = departmentId;
        this.preferenceWT = preferenceWT;
        this.currentWT = currentWT;
    }

    public WorkingHours() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getRoleId() {
        return roleId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public int getPreferenceWT() {
        return preferenceWT;
    }

    public int getCurrentWT() {
        return currentWT;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
