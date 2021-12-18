package com.trackensure.finaltask.integration.dao;

import com.trackensure.finaltask.integration.valueobject.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.trackensure.finaltask.RequestsDBConstants.*;

/**
 * ---------------------------------------------------------------------------------------------------------------- <br>
 * DepartmentDAO класс обеспечивает CRUD работу с таблицей департаментов в базе данных. <br>
 * ---------------------------------------------------------------------------------------------------------------- <br>
 */
public class DepartmentDAO {

    /**
     * ------------------------------------------------------ <br>
     * Список всех департаментов из БД. <br>
     * ------------------------------------------------------ <br>
     */
    public List<Department> findAllDep() {
        Connection connection = ConnectionManager.getInstance().getConnection();
        List<Department> resultDepList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL_DEPARTMENTS);
            while (rs.next()) {
                int departmentId = rs.getInt("department_id");
                String departmentName = rs.getString("department_name");

                Department department = new Department(departmentId, departmentName);
                resultDepList.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultDepList;
    }

    /**
     * ------------------------------------------------------ <br>
     * Добавление в БД нового департамента. <br>
     * ------------------------------------------------------ <br>
     */
    public void addNewDepartment(Department department) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(ADD_NEW_DEPARTMENTS);
            ps.setString(1, department.getDepartmentName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * ------------------------------------------------------ <br>
     * Изменение данных о департаменте в БД. <br>
     * ------------------------------------------------------ <br>
     */
    public boolean updateDepartment(Department department) {
        // По условию задания данный метод реализовывать необязательно.
        return false;
    }

    /**
     * ------------------------------------------------------ <br>
     * Найти департамент по ID. <br>
     * ------------------------------------------------------ <br>
     */
    public Department findDepartmentByID(int id) {
        // По условию задания данный метод реализовывать необязательно.
        return null;
    }

    /**
     * ------------------------------------------------------ <br>
     * Удалить департамент по ID. <br>
     * ------------------------------------------------------ <br>
     */
    public boolean deleteDepartmentByID(int id) {
        // По условию задания данный метод реализовывать необязательно.
        return false;
    }
}
