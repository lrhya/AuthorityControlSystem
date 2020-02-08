package com.lrh.AuthorityControl.entity;

public class User {
    private Integer tId;

    private String loginAcct;

    private String userPswd;

    private String userName;

    private String userEmail;

    private String departFather;

    private String departSon;

    private String createtime;


    public User() {
    }

    public User(Integer tId, String loginAcct, String userPswd, String userName, String userEmail, String departFather, String departSon, String createtime) {
        this.tId = tId;
        this.loginAcct = loginAcct;
        this.userPswd = userPswd;
        this.userName = userName;
        this.userEmail = userEmail;
        this.departFather = departFather;
        this.departSon = departSon;
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "User{" +
                "tId=" + tId +
                ", loginAcct='" + loginAcct + '\'' +
                ", userPswd='" + userPswd + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", departFather='" + departFather + '\'' +
                ", departSon='" + departSon + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String getLoginAcct() {
        return loginAcct;
    }

    public void setLoginAcct(String loginAcct) {
        this.loginAcct = loginAcct == null ? null : loginAcct.trim();
    }

    public String getUserPswd() {
        return userPswd;
    }

    public void setUserPswd(String userPswd) {
        this.userPswd = userPswd == null ? null : userPswd.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getDepartFather() {
        return departFather;
    }

    public void setDepartFather(String departFather) {
        this.departFather = departFather == null ? null : departFather.trim();
    }

    public String getDepartSon() {
        return departSon;
    }

    public void setDepartSon(String departSon) {
        this.departSon = departSon == null ? null : departSon.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }
}