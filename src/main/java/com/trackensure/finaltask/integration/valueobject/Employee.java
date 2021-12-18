package com.trackensure.finaltask.integration.valueobject;

public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private int departmentId;
    private int roleId;
    private int salary;
    private int salaryTypeId;

    public Employee(int employeeId, String firstName, String lastName, int departmentId, int roleId, int salary, int salaryTypeId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.roleId = roleId;
        this.salary = salary;
        this.salaryTypeId = salaryTypeId;
    }

    public Employee(String firstName, String lastName, int departmentId, int roleId, int salary, int salaryTypeId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.roleId = roleId;
        this.salary = salary;
        this.salaryTypeId = salaryTypeId;
    }

    public Employee() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getRoleId() {
        return roleId;
    }

    public int getSalary() {
        return salary;
    }

    public int getSalaryTypeId() {
        return salaryTypeId;
    }
}


