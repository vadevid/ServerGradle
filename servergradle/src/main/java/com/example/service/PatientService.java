package com.example.service;

import com.example.entity.Patient;
import com.example.models.PatientModel;
import com.example.repository.PatientRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Singleton
public class PatientService {

    @Inject
    PatientRepository patientRepository;

    public void save(PatientModel patient) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Patient repoPatient = new Patient(patient.getSecondName(), patient.getFirstName(), patient.getMiddleName(),
                    patient.getLogin(), patient.getPassword(), formatter.parse(patient.getBirthdate()), patient.getEmail());
            patientRepository.save(repoPatient);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
