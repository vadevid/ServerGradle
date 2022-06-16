package com.example.dto;

import java.io.Serializable;
import java.util.Objects;

public class CardDto implements Serializable {
    private final Integer id;
    private final String name;
    private final PatientDto patient;
    private final DoctorDto doctor;
    private final String type;

    public CardDto(Integer id, String name, PatientDto patient, DoctorDto doctor, String type) {
        this.id = id;
        this.name = name;
        this.patient = patient;
        this.doctor = doctor;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PatientDto getPatient() {
        return patient;
    }

    public DoctorDto getDoctor() {
        return doctor;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardDto entity = (CardDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.patient, entity.patient) &&
                Objects.equals(this.doctor, entity.doctor) &&
                Objects.equals(this.type, entity.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, patient, doctor, type);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "patient = " + patient + ", " +
                "doctor = " + doctor + ", " +
                "type = " + type + ")";
    }
}
