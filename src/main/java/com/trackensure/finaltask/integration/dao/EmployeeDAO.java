package com.trackensure.finaltask.integration.dao;

import com.trackensure.finaltask.integration.valueobject.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.trackensure.finaltask.RequestsDBConstants.ADD_NEW_EMPLOYEE;
import static com.trackensure.finaltask.RequestsDBConstants.SELECT_ALL_EMPLOYEES;

/**
 * ---------------------------------------------------------------------------------------------------------------- <br>
 * EmployeeDAO класс обеспечивает CRUD работу с таблицей сотрудников в базе данных. <br>
 * ---------------------------------------------------------------------------------------------------------------- <br>
 */
public class EmployeeDAO {

    /**
     * ------------------------------------------------------ <br>
     * Список всех сотрудников из БД. <br>
     * ------------------------------------------------------ <br>
     */
    public List<Employee> findAllEmp() {
        Connection connection = ConnectionManager.getInstance().getConnection();
        List<Employee> resultEmpList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL_EMPLOYEES);
            while (rs.next()) {
                int employeeId = rs.getInt("employee_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int departmentId = rs.getInt("department_id");
                int roleId = rs.getInt("role_id");
                int salary = rs.getInt("salary");
                int salaryTypeId = rs.getInt("salary_type_id");
                Employee employee = new Employee(employeeId, firstName, lastName, departmentId, roleId, salary, salaryTypeId);
                resultEmpList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultEmpList;
    }

    /**
     * ------------------------------------------------------ <br>
     * Добавление в БД нового сотрудника. <br>
     * ------------------------------------------------------ <br>
     */
    public void addNewEmployee(Employee employee) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(ADD_NEW_EMPLOYEE);
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setInt(3, employee.getDepartmentId());
            ps.setInt(4, employee.getRoleId());
            ps.setInt(5, employee.getSalary());
            ps.setInt(6, employee.getSalaryTypeId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * ------------------------------------------------------ <br>
     * Изменение данных о сотруднике в БД. <br>
     * ------------------------------------------------------ <br>
     */
    public boolean updateEmployee(Employee employee) {
        // По условию задания данный метод реализовывать необязательно.
        return false;
    }

    /**
     * ------------------------------------------------------ <br>
     * Найти сотрудника по ID. <br>
     * ------------------------------------------------------ <br>
     */
    public Employee findEmployeeByID(int id) {
        // По условию задания данный метод реализовывать необязательно.
        return null;
    }

    /**
     * ------------------------------------------------------ <br>
     * Удалить сотрудника по ID. <br>
     * ------------------------------------------------------ <br>
     */
    public boolean deleteEmployeeByID(int id) {
        // По условию задания данный метод реализовывать необязательно.
        return false;
    }
}
