package com.trackensure.finaltask.integration.dao;

import com.trackensure.finaltask.integration.valueobject.SalaryType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.trackensure.finaltask.RequestsDBConstants.*;

/**
 * ---------------------------------------------------------------------------------------------------------------- <br>
 * SalaryTypeDAO класс обеспечивает CRUD работу с таблицей методик расчета ЗП в базе данных. <br>
 * ---------------------------------------------------------------------------------------------------------------- <br>
 */
public class SalaryTypeDAO {

    /**
     * ------------------------------------------------------------ <br>
     * Список всех методик расчета ЗП из БД. <br>
     * ------------------------------------------------------------ <br>
     */
    public List<SalaryType> findAllSalaryType() {
        Connection connection = ConnectionManager.getInstance().getConnection();
        List<SalaryType> resultSalaryTypeList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL_SALARY_TYPE);
            while (rs.next()) {
                int salaryTypeId = rs.getInt("salary_type_id");
                String salaryTypeName = rs.getString("salary_type_name");

                SalaryType salaryType = new SalaryType(salaryTypeId, salaryTypeName);
                resultSalaryTypeList.add(salaryType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSalaryTypeList;
    }

    /**
     * ------------------------------------------------------------ <br>
     * Добавление в БД новой методики расчета ЗП. <br>
     * ------------------------------------------------------------ <br>
     */
    public void addNewSalaryType(SalaryType salaryType) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(ADD_NEW_SALARY_TYPE);
            ps.setString(1, salaryType.getSalaryTypeName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * ------------------------------------------------------------ <br>
     * Изменение данных о методике расчета ЗП в БД. <br>
     * ------------------------------------------------------------ <br>
     */
    public boolean updateSalaryType(SalaryType salaryType) {
        // По условию задания данный метод реализовывать необязательно.
        return false;
    }

    /**
     * ------------------------------------------------------------ <br>
     * Найти методику расчета ЗП по ID. <br>
     * ------------------------------------------------------------ <br>
     */
    public SalaryType findSalaryTypeByID(int id) {
        // По условию задания данный метод реализовывать необязательно.
        return null;
    }

    /**
     * ------------------------------------------------------------ <br>
     * Удалить методику расчета ЗП по ID. <br>
     * ------------------------------------------------------------ <br>
     */
    public boolean deleteSalaryTypeByID(int id) {
        // По условию задания данный метод реализовывать необязательно.
        return false;
    }
}
