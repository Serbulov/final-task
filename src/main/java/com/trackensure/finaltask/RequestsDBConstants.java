package com.trackensure.finaltask;

/**
 * ---------------------------------------------------------------------------------------------------------------- <br>
 * Класс содержит константы запросов к БД. <br>
 * ---------------------------------------------------------------------------------------------------------------- <br>
 */
public class RequestsDBConstants {
    /**
     * -------------------------------------------------------- <br>
     * Запросы к таблице Employees. <br>
     * -------------------------------------------------------- <br>
     */
    public static final String SELECT_ALL_EMPLOYEES = "select * from employees";
    public static final String ADD_NEW_EMPLOYEE = "insert into employees " +
            "(first_name, last_name, department_id, role_id, salary, salary_type_id) " +
            "VALUES (?, ?, ?, ?, ?, ?)";
    public static final String GET_EMP_DEP_ROLE_ID_OF_LAST_EMPLOYEE = "SELECT employee_id, department_id, role_id from employees " +
            "order by employee_id desc limit 1";

    /**
     * -------------------------------------------------------- <br>
     * Запросы к таблице Department. <br>
     * -------------------------------------------------------- <br>
     */
    public static final String SELECT_ALL_DEPARTMENTS = "select * from department";
    public static final String ADD_NEW_DEPARTMENTS = "insert into department (department_name) values (?)";

    /**
     * -------------------------------------------------------- <br>
     * Запросы к таблице Role. <br>
     * -------------------------------------------------------- <br>
     */
    public static final String SELECT_ALL_ROLE = "select * from role";
    public static final String ADD_NEW_ROLE = "insert into role (role_name, functional_area) VALUES (?, ?)";

    /**
     * -------------------------------------------------------- <br>
     * Запросы к таблице Salaries. <br>
     * -------------------------------------------------------- <br>
     */
    public static final String SELECT_ALL_SALARY_TYPE = "select * from salaries";
    public static final String ADD_NEW_SALARY_TYPE = "insert into salaries (salary_type_name) values (?)";

    /**
     * -------------------------------------------------------- <br>
     * Запросы к таблице Working_Hours. <br>
     * -------------------------------------------------------- <br>
     */
    public static final String SELECT_ALL_WORKING_HOURS = "select * from working_hours";
    public static final String ADD_NEW_EMP_IN_WORKING_HOURS = "insert into working_hours " +
            "(employee_id, role_id, department_id) values (?, ?, ?)";
    public static final String UPDATE_PREFERRED_WORKING_HOURS_FOR_EMP = "update working_hours set preferance_wt = ? " +
            "where employee_id = ?";
    public static final String UPDATE_PREFERRED_WORKING_HOURS_FOR_DEP = "update working_hours set preferance_wt = ? " +
            "where department_id = ?";
    public static final String UPDATE_CURRENT_WORKING_HOURS_FOR_EMP = "update working_hours set current_wt = ? " +
            "where employee_id = ?";
    public static final String UPDATE_CURRENT_WORKING_HOURS_FOR_DEP = "update working_hours set current_wt = ? " +
            "where department_id = ?";

    /**
     * -------------------------------------------------------- <br>
     * Запросы к таблице Employees и Department. <br>
     * -------------------------------------------------------- <br>
     */
    public static final String SELECT_ALL_EMP_FOR_PROFIT = "select wh.employee_id, first_name, last_name, wh.department_id, department_name, preferance_wt, current_wt\n" +
            "from working_hours wh\n" +
            "         left join employees e on e.employee_id = wh.employee_id\n" +
            "         left join department d on d.department_id = wh.department_id";
}
