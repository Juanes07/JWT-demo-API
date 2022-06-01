package com.DEMOJWT.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Modelo User
 *
 * @author Juan Pablo Toro, Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */


@Entity
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String user;
    private String pwd;
    private String token;

    /**
     * Constructor
     * @param id   Long
     * @param user String
     * @param pwd  String
     */

    public User(Long id, String user, String pwd) {
        this.id = id;
        this.user = user;
        this.pwd = pwd;
    }

    public User() {

    }

    /**
     * Metodos de acceso y obtencion
     *
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
