package com.example.dto;

import java.io.Serializable;
import java.util.Objects;

public class ContactingADoctorDto implements Serializable {
    private final Integer id;
    private final PatientDto patient;
    private final DoctorDto doctor;
    private final String text;

    public ContactingADoctorDto(Integer id, PatientDto patient, DoctorDto doctor, String text) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public PatientDto getPatient() {
        return patient;
    }

    public DoctorDto getDoctor() {
        return doctor;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactingADoctorDto entity = (ContactingADoctorDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.patient, entity.patient) &&
                Objects.equals(this.doctor, entity.doctor) &&
                Objects.equals(this.text, entity.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient, doctor, text);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "patient = " + patient + ", " +
                "doctor = " + doctor + ", " +
                "text = " + text + ")";
    }
}
