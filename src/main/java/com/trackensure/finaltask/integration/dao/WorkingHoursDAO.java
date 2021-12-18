package com.trackensure.finaltask.integration.dao;

import com.trackensure.finaltask.integration.valueobject.WorkingHours;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.trackensure.finaltask.RequestsDBConstants.*;

/**
 * ---------------------------------------------------------------------------------------------------------------- <br>
 * WorkingHoursDAO класс обеспечивает CRUD работу с таблицей рабочих часов в базе данных. <br>
 * ---------------------------------------------------------------------------------------------------------------- <br>
 */
public class WorkingHoursDAO {

    /**
     * ---------------------------------------------------------------------------------------------- <br>
     * Список всех рабочих часов из БД. <br>
     * ---------------------------------------------------------------------------------------------- <br>
     */
    public List<WorkingHours> findAllWorkingHours() {
        Connection connection = ConnectionManager.getInstance().getConnection();
        List<WorkingHours> resultWorkingHoursList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL_WORKING_HOURS);
            while (rs.next()) {
                int employeeId = rs.getInt("employee_id");
                int roleId = rs.getInt("role_id");
                int departmentId = rs.getInt("department_id");
                int preferenceWT = rs.getInt("preferance_wt");
                int currentWT = rs.getInt("current_wt");

                WorkingHours workingHours = new WorkingHours(employeeId, roleId, departmentId, preferenceWT, currentWT);
                resultWorkingHoursList.add(workingHours);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultWorkingHoursList;
    }

    /**
     * ---------------------------------------------------------------------------------------------- <br>
     * Добавление в БД WorkingHours последнего добавленного в БД сотрудника. <br>
     * ---------------------------------------------------------------------------------------------- <br>
     */
    public void addNewWorkingHours() {
        Connection connection = ConnectionManager.getInstance().getConnection();
        WorkingHours workingHours = new WorkingHours();
        try {
            /*  Эта часть достаёт из employees последнего добавленного сотрудника   */
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(GET_EMP_DEP_ROLE_ID_OF_LAST_EMPLOYEE);
            while (rs.next()) {
                workingHours.setEmployeeId(rs.getInt("employee_id"));
                workingHours.setRoleId(rs.getInt("role_id"));
                workingHours.setDepartmentId(rs.getInt("department_id"));
            }

            /*  Эта часть добавляет в working_hours взятого ранее сотрудника    */
            PreparedStatement ps = connection.prepareStatement(ADD_NEW_EMP_IN_WORKING_HOURS);
            ps.setInt(1, workingHours.getEmployeeId());
            ps.setInt(2, workingHours.getRoleId());
            ps.setInt(3, workingHours.getDepartmentId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * ---------------------------------------------------------------------------------------------- <br>
     * Изменить желаемое рабочее времени сотруднику. <br>
     * ---------------------------------------------------------------------------------------------- <br>
     */
    public void updatePreferenceWTForEmp(int employeeId, int workingHoursCode) {
        updateWT(employeeId, workingHoursCode, UPDATE_PREFERRED_WORKING_HOURS_FOR_EMP);
    }

    /**
     * ---------------------------------------------------------------------------------------------- <br>
     * Изменить желаемое рабочее время всему департаменту. <br>
     * ---------------------------------------------------------------------------------------------- <br>
     */
    public void updatePreferenceWTForDep(int departmentID, int workingHoursCode) {
        updateWT(departmentID, workingHoursCode, UPDATE_PREFERRED_WORKING_HOURS_FOR_DEP);
    }
    /**
     * --------------------------------------------------------------------------------------------- <br>
     * Изменить действующее рабочее времени сотруднику. <br>
     * --------------------------------------------------------------------------------------------- <br>
     */
    public void updateCurrentWTForEmp(int employeeId, int workingHoursCode) {
        updateWT(employeeId, workingHoursCode, UPDATE_CURRENT_WORKING_HOURS_FOR_EMP);
    }

    /**
     * ---------------------------------------------------------------------------------------------- <br>
     * Изменить действующее рабочее время всему департаменту. <br>
     * ---------------------------------------------------------------------------------------------- <br>
     */
    public void updateCurrentWTForDep(int departmentID, int workingHoursCode) {
        updateWT(departmentID, workingHoursCode, UPDATE_CURRENT_WORKING_HOURS_FOR_DEP);
    }


    /**
     * ------------------------------------------------------------------------------------------------------------ <br>
     * Общий метод для изменения желаемого / действующего рабочего времени для сотрудников и департаментов <br>
     * @param ID сотрудника или департамента <br>
     * @param workingHoursCode значение, которое будет добавлено в БД <br>
     * @param updateCurrentWorkingHoursForDep SQL запрос <br>
     * ------------------------------------------------------------------------------------------------------------ <br>
     */
    private void updateWT(int ID, int workingHoursCode, String updateCurrentWorkingHoursForDep) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(updateCurrentWorkingHoursForDep);
            ps.setInt(1, workingHoursCode);
            ps.setInt(2, ID);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * ---------------------------------------------------------------------------------------------- <br>
     * Найти рабочие часы сотрудника по его ID. <br>
     * ---------------------------------------------------------------------------------------------- <br>
     */
    public WorkingHours findWorkingHoursOfEmpByID(int id) {
        // По условию задания данный метод реализовывать необязательно.
        return null;
    }

    /**
     * ---------------------------------------------------------------------------------------------- <br>
     * Удалить рабочие часы сотрудника при удалении самого сотрудника (по ID сотрудника). <br>
     * ---------------------------------------------------------------------------------------------- <br>
     */
    public boolean deleteWorkingHoursForEmpByID(int id) {
        // По условию задания данный метод реализовывать необязательно.
        return false;
    }
}