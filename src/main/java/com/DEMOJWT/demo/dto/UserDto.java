package com.DEMOJWT.demo.dto;

/**
 * Dto User
 *
 * @author Juan Pablo Toro, Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

public class UserDto {

    private Long id;
    private String user;
    private String pwd;

    /**
     * constructor
     *
     * @param id   Long
     * @param user String
     * @param pwd  String
     */

    public UserDto(Long id, String user, String pwd) {
        this.id = id;
        this.user = user;
        this.pwd = pwd;
    }

    public UserDto() {
    }

    /**
     * metodos de acceso y obtencion.
     */

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
