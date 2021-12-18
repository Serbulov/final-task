package com.trackensure.finaltask.integration.dao;

import com.trackensure.finaltask.integration.valueobject.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.trackensure.finaltask.RequestsDBConstants.*;

/**
 * ---------------------------------------------------------------------------------------------------------------- <br>
 * RoleDAO класс обеспечивает CRUD работу с таблицей ролей в базе данных. <br>
 * ---------------------------------------------------------------------------------------------------------------- <br>
 */
public class RoleDAO {

    /**
     * ------------------------------------------------------ <br>
     * Список всех ролей из БД. <br>
     * ------------------------------------------------------ <br>
     */
    public List<Role> findAllRole() {
        Connection connection = ConnectionManager.getInstance().getConnection();
        List<Role> resultRoleList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL_ROLE);
            while (rs.next()) {
                int roleId = rs.getInt("role_id");
                String roleName = rs.getString("role_name");
                String roleFunctionArea = rs.getString("functional_area");

                Role role = new Role(roleId, roleName, roleFunctionArea);
                resultRoleList.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultRoleList;
    }

    /**
     * ------------------------------------------------------ <br>
     * Добавление в БД нового департамента. <br>
     * ------------------------------------------------------ <br>
     */
    public void addNewRole(Role role) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(ADD_NEW_ROLE);
            ps.setString(1, role.getRoleName());
            ps.setString(2, role.getRoleFunctionArea());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * ------------------------------------------------------ <br>
     * Изменение данных о роли в БД. <br>
     * ------------------------------------------------------ <br>
     */
    public boolean updateRole(Role role) {
        // По условию задания данный метод реализовывать необязательно.
        return false;
    }

    /**
     * ------------------------------------------------------ <br>
     * Найти роль по ID. <br>
     * ------------------------------------------------------ <br>
     */
    public Role findRoleByID(int id) {
        // По условию задания данный метод реализовывать необязательно.
        return null;
    }

    /**
     * ------------------------------------------------------ <br>
     * Удалить роль по ID. <br>
     * ------------------------------------------------------ <br>
     */
    public boolean deleteRoleByID(int id) {
        // По условию задания данный метод реализовывать необязательно.
        return false;
    }
}
