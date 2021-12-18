package com.trackensure.finaltask.integration.valueobject.profit;

import java.util.Objects;

/**
 * ---------------------------------------------------------------------------------------------------------------- <br>
 * Объект представления прибыли для всех департаментов по отдельности <br>
 * ---------------------------------------------------------------------------------------------------------------- <br>
 */
public class DepartmentProfit {
    private final int departmentID;
    private final String departmentName;
    private double departmentProfit;

    public DepartmentProfit(int departmentID, String departmentName, double departmentProfit) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.departmentProfit = departmentProfit;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public double getDepartmentProfit() {
        return departmentProfit;
    }

    public void setDepartmentProfit(double departmentProfit) {
        this.departmentProfit = departmentProfit;
    }
}
