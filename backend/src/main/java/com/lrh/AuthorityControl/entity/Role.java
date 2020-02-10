package com.lrh.AuthorityControl.entity;

public class Role {
    private Integer tId;

    private String roleName;



    public Role() {
    }

    public Role(Integer tId, String roleName) {
        this.tId = tId;
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "tId=" + tId +
                ", roleName='" + roleName + '\'' +
                '}';
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }
}