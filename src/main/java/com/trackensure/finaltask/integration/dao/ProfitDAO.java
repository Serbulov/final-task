package com.trackensure.finaltask.integration.dao;

import com.trackensure.finaltask.integration.valueobject.profit.EmployeeProfit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.trackensure.finaltask.RequestsDBConstants.SELECT_ALL_EMP_FOR_PROFIT;
import static com.trackensure.finaltask.integration.valueobject.profit.profitCalculate.profitCalc;

/**
 * ---------------------------------------------------------------------------------------------------------------- <br>
 * Класс доступа к БД для формирования JSON о прибыли | убытках. <br>
 * ---------------------------------------------------------------------------------------------------------------- <br>
 */
public class ProfitDAO {

    /**
     * ---------------------------------------------------------------------------------- <br>
     * Список всех сотрудников с индивидуальной прибылью / убытком. <br>
     * ---------------------------------------------------------------------------------- <br>
     */
    public List<EmployeeProfit> profitForAllEmp() {
        Connection connection = ConnectionManager.getInstance().getConnection();
        List<EmployeeProfit> profitEmpList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL_EMP_FOR_PROFIT);
            while (rs.next()) {
                int employeeId = rs.getInt("employee_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int departmentId = rs.getInt("department_id");
                String departmentName = rs.getString("department_name");
                int preferenceWT = rs.getInt("preferance_wt");
                int currentWT = rs.getInt("current_wt");
                double profit = profitCalc(preferenceWT, currentWT);

                EmployeeProfit profitEmp = new EmployeeProfit(employeeId, firstName, lastName, departmentId, departmentName, profit);
                profitEmpList.add(profitEmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profitEmpList;
    }
}

