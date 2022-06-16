package com.example.dto;

import java.io.Serializable;
import java.util.Objects;

public class DoctorDto implements Serializable {
    private final Integer id;
    private final String secondName;
    private final String firstName;
    private final String middleName;
    private final String login;
    private final String password;

    public DoctorDto(Integer id, String secondName, String firstName, String middleName, String login, String password) {
        this.id = id;
        this.secondName = secondName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.login = login;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorDto entity = (DoctorDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.secondName, entity.secondName) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.middleName, entity.middleName) &&
                Objects.equals(this.login, entity.login) &&
                Objects.equals(this.password, entity.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, secondName, firstName, middleName, login, password);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "secondName = " + secondName + ", " +
                "firstName = " + firstName + ", " +
                "middleName = " + middleName + ", " +
                "login = " + login + ", " +
                "password = " + password + ")";
    }
}
