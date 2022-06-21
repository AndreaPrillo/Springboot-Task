package com.web.springboot.demo.entities;

import java.sql.Timestamp;

public class USER extends Base{

    private String name;
    private String surname;
    private String username;

    public USER() {
        super();
    }

    public USER(long id,Timestamp createdAt,String createdBy,String name, String surname, String username) {
        super(id,createdAt,createdBy);
        this.name = name;
        this.surname = surname;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "USER{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", id=" + id +
                ", createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
