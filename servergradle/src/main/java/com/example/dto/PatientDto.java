package com.example.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class PatientDto implements Serializable {
    private final Integer id;
    private final String secondName;
    private final String firstName;
    private final String middleName;
    private final String email;
    private final String login;
    private final String password;
    private final LocalDate birthdate;
    private final String sex;

    public PatientDto(Integer id, String secondName, String firstName, String middleName, String email, String login, String password, LocalDate birthdate, String sex) {
        this.id = id;
        this.secondName = secondName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.email = email;
        this.login = login;
        this.password = password;
        this.birthdate = birthdate;
        this.sex = sex;
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

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientDto entity = (PatientDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.secondName, entity.secondName) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.middleName, entity.middleName) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.login, entity.login) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.birthdate, entity.birthdate) &&
                Objects.equals(this.sex, entity.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, secondName, firstName, middleName, email, login, password, birthdate, sex);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "secondName = " + secondName + ", " +
                "firstName = " + firstName + ", " +
                "middleName = " + middleName + ", " +
                "email = " + email + ", " +
                "login = " + login + ", " +
                "password = " + password + ", " +
                "birthdate = " + birthdate + ", " +
                "sex = " + sex + ")";
    }
}
