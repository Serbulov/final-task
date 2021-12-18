package com.trackensure.finaltask.integration.valueobject;

public class Role {
    private int roleId;
    private String roleName;
    private String roleFunctionArea;

    public Role(int roleId, String roleName, String roleFunctionArea) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleFunctionArea = roleFunctionArea;
    }

    public Role(String roleName, String roleFunctionArea) {
        this.roleName = roleName;
        this.roleFunctionArea = roleFunctionArea;
    }

    public Role() {
    }

    public int getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getRoleFunctionArea() {
        return roleFunctionArea;
    }
}
