package com.example.service;

import com.example.entity.DefaultValue;
import com.example.entity.Patient;
import com.example.models.PatientInfoModel;
import com.example.models.PatientModel;
import com.example.repository.DefaultValueRepository;
import com.example.repository.PatientRepository;
import com.google.common.hash.Hashing;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Singleton
public class PatientService {

    @Inject
    PatientRepository patientRepository;
    @Inject
    DefaultValueRepository defaultValueRepository;

    public boolean save(PatientModel patient) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        Patient repoPatient = new Patient(patient.getSecondName(), patient.getFirstName(), patient.getMiddleName(),
                patient.getEmail(), patient.getLogin(), Hashing.sha256().hashString(patient.getPassword(), StandardCharsets.UTF_8).toString(),
                LocalDate.parse(patient.getBirthdate(), formatter),patient.getSex());
        DefaultValue defaultValue = new DefaultValue(repoPatient, 0, 0);
        patientRepository.save(repoPatient);
        defaultValueRepository.save(defaultValue);
        return true;
    }

    public String login(Patient patient) {
        try {
            Patient tmp = patientRepository.getByLogin(patient.getLogin());
            if (tmp.getPassword().equals(Hashing.sha256().hashString(patient.getPassword(), StandardCharsets.UTF_8).toString())) {
                return "0" + tmp.getId();
            } else return  "1";
        } catch (Exception e) {
            return "2";
        }
    }
    public PatientInfoModel patientinfo(Patient patient) {
        try {
            Patient tmp = patientRepository.getById(patient.getId());
            DefaultValue defaultValue = defaultValueRepository.findFirstByPatientOrderByIdDesc(tmp);
            PatientInfoModel patientInfo = new PatientInfoModel(tmp.getFIO(),
                    tmp.getAge().toString(), tmp.getSex(), String.valueOf(defaultValue.getGrowth()),
                    String.valueOf(defaultValue.getWeight()), String.valueOf(defaultValue.getMassIndex()));
            return patientInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
