package com.DEMOJWT.demo.dto;

public class UserDto {

    private Long id;
    private String user;
    private String pwd;
//    private String token;

    public UserDto(Long id, String user, String pwd) {
        this.id = id;
        this.user = user;
        this.pwd = pwd;
    }

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
