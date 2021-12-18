package com.trackensure.finaltask.integration.valueobject.profit;

/**
 * ---------------------------------------------------------------------------------------------------------------- <br>
 * Объект представления прибыли для всех сотрудников по отдельности <br>
 * ---------------------------------------------------------------------------------------------------------------- <br>
 */
public class EmployeeProfit implements profitCalculate {
    private final int employeeID;
    private final String firstName;
    private final String lastName;
    private final int departmentID;
    private final String departmentName;
    private final double profit;

    public EmployeeProfit(int employeeID, String firstName, String lastName, int departmentID, String departmentName, double profit) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.profit = profit;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public double getProfit() {
        return profit;
    }
}
