package com.DEMOJWT.demo.dto;

public class UserDto {

    private String user;
    private String pwd;

    public UserDto(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
    }

    public UserDto() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
