package com.example.controller;

import com.example.entity.Patient;
import com.example.models.PatientModel;
import com.example.repository.PatientRepository;
import com.example.service.PatientService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;

import javax.validation.Valid;
import java.util.List;

@Controller
@Secured(SecurityRule.IS_ANONYMOUS)
public class PatientController {


    @Inject
    PatientRepository patientRepository;

    @Inject
    PatientService patientService;

    @Post("/patient/list")
    public List<Patient> getPatientList() { return patientRepository.findAll(); }

    @Post(value = "/patient/register", consumes = MediaType.APPLICATION_JSON)
    public void RegisterPatient(@Body @Valid PatientModel patient) {
        patientService.save(patient);
    }
}
